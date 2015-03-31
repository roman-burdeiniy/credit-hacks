package com.credithacks.responseBuilders;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by roman_b on 3/19/2015.
 */
public class ResponseBuilderBase {

    protected String fieldName = "data";

    public Object buildResponse(Object dto, String errorMessage){
        JSONObject result = new JSONObject();
        try{
            result.put(fieldName, dto);
        }catch(JSONException e){
            return errorMessage;
        }finally {
            return result;
        }
    }

}
