package com.hospital_management_system.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class EncodePassword {
    public static void main(String[] args) {
        PasswordEncoder encodePassword = new BCryptPasswordEncoder();
        System.out.println(encodePassword.encode("password"));
    }
}
