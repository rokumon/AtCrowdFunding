package com.atguigu.atcrowdfunding.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.atcrowdfunding.controller.BaseController;

@Controller
@RequestMapping(value="/param")
public class ParamController extends BaseController {
	
	@RequestMapping(value="/index.htm")
	public String index() {
		return "/param/index";
	}
	
}
