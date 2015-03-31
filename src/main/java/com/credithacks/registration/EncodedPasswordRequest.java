package com.credithacks.registration;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by roman_b on 3/17/2015.
 */
public class EncodedPasswordRequest extends HttpServletRequestWrapper{
    public EncodedPasswordRequest(ServletRequest request) {
       super((HttpServletRequest)request);
        Enumeration<String> params = request.getParameterNames();
       /* for (String paramName : params) {
            if("j_password".equals(paramName)){
                String
            }
            String paramValue = parameters.getParameterValue(paramName);
            coyoteParameters.addParameter(paramName, paramValue);
        }
        request.getParameterNames()*/
    }

    Map<String, String[]> parameterMap;

    @Override
    public Map<String, String[]> getParameterMap()
    {
        return parameterMap;
    }


    public String[] getParameterValues(String paramName) {
        String values[] = super.getParameterValues(paramName);
        if ("j_password".equals(paramName)) {

        }
        return values;
    }
}
