package com.example.testwalle.controller;

import com.example.testwalle.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/6/15.
 */
@RestController
public class WallesController {

	@Autowired
	private ServerConfig serverConfig;

	@RequestMapping("/walle")
	public String walle(){
		return "build walle success2 with jenkinsfile " + serverConfig.getUrl();
	}

}
