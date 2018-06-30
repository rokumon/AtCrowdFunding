package com.atguigu.atcrowdfunding.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/message")
public class MessageController {
	
	@RequestMapping(value="/index.htm")
	public String index() {
		return "/message/index";
	}
}
