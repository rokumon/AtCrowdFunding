package com.atguigu.atcrowdfunding.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.atcrowdfunding.controller.BaseController;

@Controller
@RequestMapping(value="/advert")
public class AdvertController extends BaseController {
	
	@RequestMapping(value="/index.htm")
	public String index() {
		return "/advert/index";
	}
	
}
