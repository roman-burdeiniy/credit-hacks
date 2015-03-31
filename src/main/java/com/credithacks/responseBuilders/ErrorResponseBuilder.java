package com.credithacks.responseBuilders;

import com.credithacks.dto.ErrorDTO;
import com.credithacks.enums.ErrorsEnum;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by roman_b on 3/19/2015.
 */
public class ErrorResponseBuilder extends ResponseBuilderBase {

    public ErrorResponseBuilder(){
        fieldName = "error";
    }
    public Object buildLoginError() {
        JSONObject result = new JSONObject();
        ErrorDTO error = new ErrorDTO();
        error.setCode(ErrorsEnum.LOGIN_FAILED.code);
        error.setDescription(ErrorsEnum.LOGIN_FAILED.description);
        return buildResponse(error, ErrorsEnum.LOGIN_FAILED.name);
    }

    public Object buildLogoutError() {
        JSONObject result = new JSONObject();
        ErrorDTO error = new ErrorDTO();
        error.setCode(ErrorsEnum.LOGOUT_FAILED.code);
        error.setDescription(ErrorsEnum.LOGOUT_FAILED.description);
        return buildResponse(error, ErrorsEnum.LOGOUT_FAILED.name);
    }
}
