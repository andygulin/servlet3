package com.demo.listener;

import java.util.logging.Logger;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletRequestAttributeListenerTest implements ServletRequestAttributeListener {

	private static final Logger logger = Logger.getLogger(ServletRequestAttributeListenerTest.class.getName());

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		logger.info("attributeAdded");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		logger.info("attributeRemoved");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		logger.info("attributeReplaced");
	}

}
