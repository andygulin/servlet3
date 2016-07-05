package com.demo.listener;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AsyncListenerTest implements AsyncListener {

	private static final Logger logger = Logger.getLogger(AsyncListenerTest.class.getName());

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		logger.info("onComplete");
	}

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		logger.info("onTimeout");
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		logger.info("onError");
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		logger.info("onStartAsync");
	}
}