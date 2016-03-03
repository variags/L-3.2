package accounts;

/**
 * Created by m.simonov on 29.02.2016.
 */
public class UserProfile {
    private final String login;
    private String pass;
    private String email;
    private long id;


    public UserProfile(String login, String pass, String email) {
        this.login = login;
        this.pass = pass;
        this.email = email;
    }

    public UserProfile(String login) {
        this.login = login;
        //this.pass = password;
        //this.email = login;
        this.id = id;
    }



    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }
}
