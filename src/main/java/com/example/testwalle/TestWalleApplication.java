package com.example.testwalle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class TestWalleApplication {

    @Autowired
    private ServerConfig serverConfig;

    public static void main(String[] args) {
        SpringApplication.run(TestWalleApplication.class, args);
    }

    @RequestMapping("/walle")
    public String walle(HttpServletRequest request){
        return "build walle success2 " + serverConfig.getUrl();
    }

}

