package com.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortalApplication {

    @Autowired
    @Value("${name}")
    public static String myName;

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
        System.out.println("my name "+myName);

    }
}
