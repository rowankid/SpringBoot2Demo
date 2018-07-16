package cn.luowq.sample.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloSpringBoot2Controller {

	@RequestMapping("/sayhello.html")
	/**
	 * ResponseBody 注解直接将返回的对象输出到客户端。 如果是字符串 ， 则直接返回； 如果不是，则默认使用 Jackson 序列化成
	 * JSON字符串后输出 。
	 */
	public @ResponseBody String say(String name) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		return "Hello Spring Boot 2 !" + "Hello " + name + " !" + sdf.format(date);
	}
}
