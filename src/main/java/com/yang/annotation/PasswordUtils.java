package com.yang.annotation;

public class PasswordUtils {
    @UseCase(id=47,description="Passwords must contain at least one numeric")
    public boolean validatePassword(){
        return true;
    }

    @UseCase(id=48)
    public String encryptPassword(String password){
        return password;
    }

    @UseCase(id=49,description="Jong_Cai")
    public void showName(){
        System.out.println("Jong_Cai");
    }
}
