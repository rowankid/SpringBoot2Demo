package com.luowq.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloSpringBoot2Controller {

	@RequestMapping("/sayhello.html")
	// @ResponseBody返回的是文本
	public @ResponseBody String say(String name) {
		return "Hello Spring Boot 2 !" + "Hello " + name +" !";
	}
}
