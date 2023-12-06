package com.go.together;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TogetherApplication {

    public static void main(String[] args) {
        SpringApplication.run(TogetherApplication.class, args);

//
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        System.out.println("--------------아래 암호화가 잘 되어있는지 ");
//        System.out.println(passwordEncoder.encode("1234"));

    }

}
