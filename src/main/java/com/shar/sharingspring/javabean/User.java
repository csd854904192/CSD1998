package com.shar.sharingspring.javabean;

public class User {
    private int userid;
    private String username;
    private String userpwd;
    private String usersex;
    private String degree;
    private String occupation;
    private String userphone;
    private String email;
    private String regtime;
    private int roleid;
    private Role role;

    public User() {
    }

    public User(String username, String userpwd) {
        this.username = username;
        this.userpwd = userpwd;
    }

    public User(String username, String userpwd, String usersex, String degree, String occupation, String userphone, String email) {
        this.username = username;
        this.userpwd = userpwd;
        this.usersex = usersex;
        this.degree = degree;
        this.occupation = occupation;
        this.userphone = userphone;
        this.email = email;
    }

    public User(int userid, String username, String userpwd, String usersex, String degree, String occupation, String userphone, String email) {
        this.userid = userid;
        this.username = username;
        this.userpwd = userpwd;
        this.usersex = usersex;
        this.degree = degree;
        this.occupation = occupation;
        this.userphone = userphone;
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", usersex='" + usersex + '\'' +
                ", degree='" + degree + '\'' +
                ", occupation='" + occupation + '\'' +
                ", userphone='" + userphone + '\'' +
                ", email='" + email + '\'' +
                ", regtime='" + regtime + '\'' +
                ", roleid=" + roleid +
                ", role=" + role +
                '}';
    }
}
