package Account;

import Address.Address;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class User
{
    private String name;
    private String surName;
    private String eMail;
    private String password;
    private String job;

    private ArrayList<Address> usersAddress;
    static private LocalDateTime lastLogin;

    public User(String name, String surName, String eMail, String password, String job) {
        this.name = name;
        this.surName = surName;
        this.eMail = eMail;
        this.password = password;
        this.job = job;
        this.usersAddress=new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public ArrayList<Address> getUsersAddress() {
        return usersAddress;
    }

    public void setUsersAddress(ArrayList<Address> usersAddress) {
        this.usersAddress = usersAddress;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public  void setLastLogin(LocalDateTime lastLogin) {
        User.lastLogin = lastLogin;
    }
}
