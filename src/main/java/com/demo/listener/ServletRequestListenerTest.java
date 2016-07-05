package com.demo.listener;

import java.util.logging.Logger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletRequestListenerTest implements ServletRequestListener {

	private static final Logger logger = Logger.getLogger(ServletRequestListenerTest.class.getName());

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		logger.info("requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		logger.info("requestInitialized");
	}

}
