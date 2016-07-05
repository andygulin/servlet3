package com.demo.listener;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ReadListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ReadListenerTest implements ReadListener {

	private static final Logger logger = Logger.getLogger(ReadListenerTest.class.getName());

	@Override
	public void onDataAvailable() throws IOException {
		logger.info("onDataAvailable");
	}

	@Override
	public void onAllDataRead() throws IOException {
		logger.info("onAllDataRead");
	}

	@Override
	public void onError(Throwable t) {
		logger.info("onError");
	}

}
