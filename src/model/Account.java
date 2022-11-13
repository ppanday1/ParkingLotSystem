package model;

import java.util.Objects;

public class Account {
    private String userName;
    private String password;
    private AccountStatus status;
    private Person person;

    public boolean resetPassword(String oldPass,String newPass){
        if(!Objects.equals(oldPass, password))
            return false;
        password=newPass;
        return true;
    };
}
