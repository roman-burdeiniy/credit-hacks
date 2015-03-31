package com.credithacks.securityGenerator;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by roman_b on 12/19/2014.
 */
public class SecurityCodeGenerator {
    public List<String> generate(){
        Random rand = new Random();
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < 3; i++){
            int randomNum = rand.nextInt(100);
            String part = Integer.toString(randomNum);
            if (randomNum < 10){
                part = "0" + part;
            }
            result.add(part);
        }
        return result;
    }

    public String joinWithDashes(List<String> code){
        return StringUtils.join(code, "-");
    }

    public Boolean isEqual(List<String> code1, List<String> code2){
        return true;
       /* if (code1 == null && code2 == null)
            return true;
        if (code1 == null || code2 == null || code1.size() != code2.size())
            return false;
        for (int i = 0; i < code1.size(); i++){
            if (!code1.get(i).equals(code2.get(i)))
                return false;
        }
        return true;*/
    }
}
