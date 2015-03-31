package com.credithacks.registration;

import com.credithacks.ServletBase;
import com.credithacks.gateway.SMSGateway;
import com.credithacks.roles.Roles;
import com.credithacks.securityGenerator.SecurityCodeGenerator;
import com.credithacks.service.UsersService;
import com.credithacks.validator.PhoneNumberValidator;
import com.credithacks.vo.UserRolesVO;
import com.credithacks.vo.UsersVO;
import com.credithacks.voBuilders.UsersVOBuilder;
import com.creditprovider.login.EncryptedPasswordGenerator;
import org.json.JSONException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by roman_b on 12/15/2014.
 */
public class RegistrationServlet extends ServletBase {

    @Inject
    private SMSGateway smsGateway;
    @Inject
    private PhoneNumberValidator phoneValidator;
    @Inject
    private SecurityCodeGenerator codeGenerator;
    @Inject
    private UsersService usersService;

    private EncryptedPasswordGenerator passwordEncrypt;
    @Inject
    private UsersVOBuilder userBuilder;

    private List<String> generatedCode;

    public RegistrationServlet(){
        super();
        passwordEncrypt = new EncryptedPasswordGenerator();
    }

    @Override
    protected void handlePost(HttpServletRequest req, HttpServletResponse resp) throws JSONException, IOException,
            ParseException, IllegalArgumentException, Exception
    {
        super.handlePost(req, resp);

        String actionName = req.getParameter("actionName");
        switch (actionName){
            case "sendConfirmationSMS":{
                String phoneNum = req.getParameter("phone");
                if (phoneValidator.isValid(phoneNum)){
                    generatedCode = codeGenerator.generate();
                    //smsGateway.send(phoneNum, codeGenerator.joinWithDashes(generatedCode));
                }else{
                    throw new IllegalArgumentException("The phone number " + phoneNum + " is not valid");
                }
                break;
            }
            case "registerNewClient":{
                String smsCode1 = req.getParameter("smsCode1");
                String smsCode2 = req.getParameter("smsCode2");
                String smsCode3 = req.getParameter("smsCode3");
                List<String> smsCandidateCode = new ArrayList<String>(Arrays.asList(smsCode1, smsCode2, smsCode3));
                if (codeGenerator.isEqual(generatedCode, smsCandidateCode)){
                    String phoneNum = req.getParameter("phone");
                    String email = req.getParameter("email");
                    String password = req.getParameter("password");
                    byte[] salt = passwordEncrypt.generateSalt();
                    byte[] encryptedPassword = passwordEncrypt.getEncryptedPassword(password, salt);
                    UserRolesVO role = userBuilder.buildUserRole(phoneNum, Roles.CLIENT);
                    UsersVO userToAdd = userBuilder.buildUser(phoneNum, encryptedPassword, salt, email, phoneNum);

                    usersService.addUser(userToAdd, role);
                }else{
                    throw new IllegalArgumentException("The sms code is not valid");
                }
                break;
            }
        }
    }
}
