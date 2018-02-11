package com.springboot.web.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public LoginService(){
        System.out.println("loginservice===============");
    }

    public boolean validateUser(String userid, String password) {

        return userid.equalsIgnoreCase("admin")
                && password.equalsIgnoreCase("admin");
    }

}