package com.demo.listener;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListenerTest implements ServletContextListener {

	private static final Logger logger = Logger.getLogger(ServletContextListenerTest.class.getName());

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("contextInitialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("contextDestroyed");
	}

}