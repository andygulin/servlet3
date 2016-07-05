package com.demo.listener;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.WriteListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WriteListenerTest implements WriteListener {

	private static final Logger logger = Logger.getLogger(WriteListenerTest.class.getName());

	@Override
	public void onWritePossible() throws IOException {
		logger.info("onWritePossible");
	}

	@Override
	public void onError(Throwable t) {
		logger.info("onError");
	}
}