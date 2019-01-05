package com.example.testwalle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestWalleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestWalleApplication.class, args);
    }

    @RequestMapping("/walle")
    public String walle(){
        return "build walle success";
    }

}

