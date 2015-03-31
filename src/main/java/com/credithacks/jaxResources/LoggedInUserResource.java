package com.credithacks.jaxResources;

import com.credithacks.dto.UserDTO;
import com.credithacks.service.UsersService;
import com.credithacks.vo.UsersVO;
import com.creditprovider.login.NoUserFoundException;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

/**
 * Created by roman_b on 3/24/2015.
 */
@Stateless
@Path("/loggedInUser")
public class LoggedInUserResource {


    @Context
    SecurityContext securityContext;
    @Inject
    UsersService usersService;

    // The Java method will process HTTP GET requests
    @GET
    @RolesAllowed({"admin", "client"})
    @Produces("application/json")
    public Response getLoggedInUser() {
        Principal userPr = securityContext.getUserPrincipal();
        UsersVO userInfo = null;
        try{
            userInfo = usersService.getUser(userPr.getName());
        }catch (NoUserFoundException ex){
            ex.printStackTrace();
        }
        Response resp = Response.ok(new UserDTO(userInfo.getUsername(), userInfo.getEmail()), MediaType.APPLICATION_JSON_TYPE).build();
        return resp;
    }
}
