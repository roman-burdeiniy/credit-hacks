package com.credithacks;

import org.json.JSONException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;

/**
 * Created by roman_b on 11/10/2014.
 */
public class ServletBase extends javax.servlet.http.HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        try
        {
            applyResponse(resp);
            handlePost(req, resp);
        }
        catch (Exception e)
        {
            raiseException(resp, e);
        }
    }

    protected void handlePost(HttpServletRequest req, HttpServletResponse resp) throws JSONException, IOException, ParseException, Exception
    {
        req.setCharacterEncoding("UTF-8");
    }

    private void applyResponse(HttpServletResponse resp)
    {
        resp.setContentType("application/Json");
        resp.setCharacterEncoding("UTF-8");
    }

    protected void raiseException(HttpServletResponse resp, Throwable e) throws IOException
    {
        e.printStackTrace();
        resp.setContentType("text/html");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        resp.getWriter().print(stringWriter.toString());
    }
}
