package com.portal.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    public static void main(String[] args) {

        BCryptPasswordEncoder bc= new BCryptPasswordEncoder();
        System.out.println(bc.encode("srikanth"));
    }
}
