package com.atguigu.atcrowdfunding.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.atguigu.atcrowdfunding.util.Const;

/**
 * 监听ServletContext对象的创建和销毁
 * @author Administrator
 *
 */
public class StartUpSystemListener implements ServletContextListener {

	//在服务器启动 创建 ServletContext 对象时，执行此方法
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//将项目上下文路径存放到application域给jsp使用 ${APP_PATH}
		ServletContext application = sce.getServletContext();
		
		String contextPath = application.getContextPath();
		
		application.setAttribute(Const.APP_PATH, contextPath);
	}
	
	//服务器停止或卸载项目时，ServletContext 对象被销毁时执行此方法
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
