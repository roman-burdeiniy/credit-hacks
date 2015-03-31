package com.credithacks.service;

import com.credithacks.exception.UserExistsException;
import com.credithacks.vo.UserRolesVO;
import com.credithacks.vo.UsersVO;
import com.creditprovider.login.NoUserFoundException;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by roman_b on 12/29/2014.
 */
@Stateless
public class UsersService extends ServiceBase {

    public List<UsersVO> getAllUsers(){
        List<UsersVO> results = em.createNamedQuery("UsersVO.getAll")
                .getResultList();
        return results;
    }

    public void addUser(UsersVO user, UserRolesVO role) throws UserExistsException{
        List<UsersVO> results = em.createNamedQuery("UsersVO.geUserByName")
                .setParameter("username", user.getUsername())
                .getResultList();
        if (results != null && results.size() > 0)
            throw new UserExistsException("The user with name " + user.getUsername() + " is already registered");
        role.setUsersByUserId(user);
        user.setUserRolesesById(new ArrayList<UserRolesVO>(Arrays.asList(role)));
        em.persist(user);
    }

    public UsersVO getUser(String userName) throws NoUserFoundException{
        List<UsersVO> results = em.createNamedQuery("UsersVO.geUserByName")
                .setParameter("username", userName)
                .getResultList();
       if (results == null || results.size() == 0){
           throw new NoUserFoundException(userName);
       }
        return results.get(0);
    }

}
