package com.credithacks.voBuilders;

import com.credithacks.vo.UserRolesVO;
import com.credithacks.vo.UsersVO;

/**
 * Created by roman_b on 3/16/2015.
 */
public class UsersVOBuilder {

    public UsersVO buildUser(String username, byte[] password, byte[] salt, String email, String phone){
        UsersVO result = new UsersVO();
        result.setUsername(username);
        result.setPhone(phone);
        result.setEmail(email);
        result.setPassword(password);
        result.setSalt(salt);
        return result;
    }

    public UserRolesVO buildUserRole(String username, String role){
        UserRolesVO result = new UserRolesVO();
        result.setRolename(role);
        return result;
    }
}
