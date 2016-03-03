package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by m.simonov on 29.02.2016.
 */
public class SignInServlet extends HttpServlet{

    private final AccountService accountService;


    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }



    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");





        if (login == null || password == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        UserProfile profile = null;
        try {
            profile = accountService.getUser(login);
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (profile == null || !profile.getLogin().equals(login)|| !profile.getPass().equals(password)) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }





        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter pw = response.getWriter();
        pw.println("Authorized: " + request.getParameter("login"));

    }









}














