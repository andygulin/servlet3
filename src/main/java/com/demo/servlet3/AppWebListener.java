package com.demo.servlet3;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class AppWebListener implements ServletContextListener,
		ServletContextAttributeListener, ServletRequestListener,
		ServletRequestAttributeListener, HttpSessionListener,
		HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("attributeAdded");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("attributeRemoved");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("attributeReplaced");
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("sessionCreated");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionDestroyed");
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("attributeAdded");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("attributeRemoved");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("attributeReplaced");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("requestInitialized");
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("attributeAdded");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("attributeRemoved");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("attributeReplaced");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}

}
