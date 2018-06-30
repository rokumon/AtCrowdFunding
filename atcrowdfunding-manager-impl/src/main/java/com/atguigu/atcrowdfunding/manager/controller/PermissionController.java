package com.atguigu.atcrowdfunding.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.controller.BaseController;
import com.atguigu.atcrowdfunding.manager.service.PermissionService;

@Controller
@RequestMapping(value="/permission")
public class PermissionController extends BaseController {
	
	@Autowired
	private PermissionService permissionService;
	
	
	@RequestMapping(value="/index.htm")
	public String index() {
		return "/permission/index";
	}
	
	@ResponseBody
	@RequestMapping(value="/loadData.do")
	public Object loadData() {
		
		start();
		
		try {
			
			Permission root = permissionService.queryPermissionTree();
			
			data(root);
			
			success(true);
		} catch (Exception e) {
			success(false);
			message(e.getMessage());
			e.printStackTrace();
		}
		
		return end();
	}
	
	@RequestMapping(value="/toAdd.htm")
	public String toAdd() {
		return "/permission/add";
	}
	
	@ResponseBody
	@RequestMapping(value="/doAdd.do")
	public Object doAdd(Integer pid, String name, String icon, String url) {
		
		start();
		
		try {
			
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("pid", pid);
			paramMap.put("name", name);
			paramMap.put("icon", icon);
			paramMap.put("url", url);
			
			permissionService.addPermission(paramMap);
			
			success(true);
		} catch (Exception e) {
			success(false);
			message(e.getMessage());
		}
		
		return end();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/doDelete.do")
	public Object doDelete(Integer id) {
		
		start();
		
		try {
			
			permissionService.removePermission(id);
			
			success(true);
		} catch (Exception e) {
			success(false);
			message(e.getMessage());
		}
		
		return end();
	}
	
	
	
	@RequestMapping(value="/toUpdate.do")
	public String toUpdate(Integer id, Map<String, Object> map) {
		
		Permission permission = permissionService.queryPermission(id);
		
		map.put("permission", permission);
		
		return "/permission/edit";
	}
	
	@ResponseBody
	@RequestMapping(value="/doUpdate.do")
	public Object doUpdate(Integer id, String name, String icon, String url) {
		
		start();
		
		try {
			
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("id", id);
			paramMap.put("name", name);
			paramMap.put("icon", icon);
			paramMap.put("url", url);
			
			permissionService.updatePermission(paramMap);
			
			success(true);
		} catch (Exception e) {
			success(false);
			message(e.getMessage());
		}
		
		return end();
	}
}
