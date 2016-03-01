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
    // private final UsersDAO usersDAO = null;
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

        UserProfile profile = accountService.getUserByLogin(login);
        if (profile == null || !profile.getPass().equals(password)) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
      //  usersDAO.getUserId(login);
        accountService.addSession(request.getSession().getId(), profile);
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter pw = response.getWriter();
        pw.println("Authorized: " + request.getParameter("login"));

    }


  /*  public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        if (login == null || pass == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        UserProfile profile = accountService.getUserByLogin(login);
        if (profile == null || !profile.getPass().equals(pass)) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        accountService.addSession(request.getSession().getId(), profile);
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter pw = response.getWriter();
        pw.println("Authorized");

    }*/





}














