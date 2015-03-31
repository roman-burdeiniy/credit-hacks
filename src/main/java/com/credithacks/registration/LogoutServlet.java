package com.credithacks.registration;

import com.credithacks.responseBuilders.ErrorResponseBuilder;
import com.credithacks.roles.Roles;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by roman_b on 3/25/2015.
 */
public class LogoutServlet extends HttpServlet {
    @Inject
    private ErrorResponseBuilder errorBuilder;

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        try{
           req.logout();
        }catch(ServletException e){
            resp.setContentType("application/Json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().print(errorBuilder.buildLogoutError());
            e.printStackTrace();
        }
    }
}
