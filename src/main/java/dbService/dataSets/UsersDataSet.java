package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")
public class UsersDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true, updatable = false)
    private String login;
    @Column(name = "password")
    private String password;


    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet(String login, String password) {
        //this.setId(id);
        this.setPassword(password);
        this.setLogin(login);
}

    public UsersDataSet(long id) {
        this.setId(id);
        this.setLogin(login);
        this.setPassword(password);
    }



    @SuppressWarnings("UnusedDeclaration")
    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public void setPassword(String name) {
        this.password = name;
    }


    public long getId(long id) {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", name='" + login + '\'' +
                '}';
    }
}