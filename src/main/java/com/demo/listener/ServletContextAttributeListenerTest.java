package com.demo.listener;

import java.util.logging.Logger;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextAttributeListenerTest implements ServletContextAttributeListener {

	private static final Logger logger = Logger.getLogger(ServletContextAttributeListenerTest.class.getName());

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		logger.info("attributeAdded");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		logger.info("attributeRemoved");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		logger.info("attributeReplaced");
	}
}