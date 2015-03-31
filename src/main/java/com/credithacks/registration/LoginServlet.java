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
 * Created by roman_b on 3/19/2015.
 */
public class LoginServlet extends HttpServlet {

    @Inject
    private ErrorResponseBuilder errorBuilder;

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String username = req.getParameter("j_username");
        String password = req.getParameter("j_password");
        try{
            req.login(username, password);
            Boolean isAuthenticated = req.authenticate(resp);
        }catch(ServletException e){
            resp.setContentType("application/Json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().print(errorBuilder.buildLoginError());
            e.printStackTrace();
        }

        if (req.isUserInRole(Roles.CLIENT)){
            resp.sendRedirect("client/cabinet.html");
        }else if (req.isUserInRole(Roles.ADMIN)){
            resp.sendRedirect("admin/workspace.html");
        }
    }

}
