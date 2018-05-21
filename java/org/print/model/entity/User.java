package org.print.model.entity;

/**
 * Created by Alina on 17.02.2018.
 */
public class User {
    private int id;
    private String login;
    private String password;
    public enum ROLES {ADMIN, USER, UNKNOWN}

    private ROLES role;

    public User() {
    }

    public User(String login, String password, ROLES role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(int id, String login, String password, ROLES role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ROLES getRole() {
        return role;
    }
    public void setRole(ROLES role) {
        this.role = role;
    }
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
