package com.hospital_management_system.payload;

import lombok.Data;


@Data
public class LoginDTO {
    private String usernameOrEmail;
    private String password; }


