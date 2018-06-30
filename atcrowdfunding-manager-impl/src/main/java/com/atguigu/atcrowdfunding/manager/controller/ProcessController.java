package com.atguigu.atcrowdfunding.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.atcrowdfunding.controller.BaseController;

@Controller
@RequestMapping(value="/process")
public class ProcessController extends BaseController {
	
	@RequestMapping(value="/index.htm")
	public String index() {
		return "/process/index";
	}
	
}
