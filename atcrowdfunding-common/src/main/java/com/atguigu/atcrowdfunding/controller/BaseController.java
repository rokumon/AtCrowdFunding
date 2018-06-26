package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
	
	//控制器变量是单例的，成员变量会有数据安全问题
	/*
	Map<String, Object> result;
	*/
	
	//单例，但会以线程作为 Key 因此具有较好的隔离
	ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();
	
	public void start() {
		//多例
		Map<String, Object> result = new HashMap<String, Object>();
		
		//存放到当前线程的 ThreadLocal Map 中
		threadLocal.set(result);
	}
	
	public void success(boolean success) {
		Map<String, Object> result = threadLocal.get();
		result.put("success", success);
	}
	
	public void message(String message) {
		Map<String, Object> result = threadLocal.get();
		result.put("message", message);
	}
	
	public Object end() {
		Map<String, Object> result = threadLocal.get();
		return result;
	}
	
	public void data(Object data) {
		Map<String, Object> result = threadLocal.get();
		result.put("data", data);
	}
	
}
