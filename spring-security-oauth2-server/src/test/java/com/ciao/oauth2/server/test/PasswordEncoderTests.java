package com.ciao.oauth2.server.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: spring-boot-security-oauth2
 * @author: ciao
 * @description:
 * @create: 2019-08-19 16:50
 **/
public class PasswordEncoderTests {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("xuechaoke1995*"));
    }
}
