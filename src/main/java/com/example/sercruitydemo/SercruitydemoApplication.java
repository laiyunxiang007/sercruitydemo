package com.example.sercruitydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SercruitydemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SercruitydemoApplication.class, args);
    }


        @GetMapping("/user")
        public String getUsers() {
            return "Hello Spring Security";
        }

    @RequestMapping("/whoim")
    public Object whoIm()
    {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
