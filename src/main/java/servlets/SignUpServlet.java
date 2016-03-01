package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import dbService.dao.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by m.simonov on 29.02.2016.
 */
public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;
  private final UsersDAO usersDAO = null;

    public SignUpServlet(AccountService accountService) {
       this.accountService = accountService;


    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        //todo: module 2 home work

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(login != null|| password != null) {

         //   usersDAO.getUserId(login);
            accountService.addNewUser(new UserProfile(login, password, ""));
            //PrintWriter pw = response.getWriter();
            //pw.println("Done!");
            response.setStatus(HttpServletResponse.SC_OK);

        }else{
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        //accountService.addNewUser(new UserProfile(pa));

    }



}
