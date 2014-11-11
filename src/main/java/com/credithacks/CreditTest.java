package com.credithacks;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * Created by roman_b on 11/10/2014.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("credit")
public class CreditTest {
    public CreditTest() {
    }
    // The Java method will process HTTP GET requests
    @GET
    @Produces("text/html")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }
}
