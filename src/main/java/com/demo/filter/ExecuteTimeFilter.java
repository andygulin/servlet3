package com.demo.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.commons.lang3.time.StopWatch;

@WebFilter(filterName = "ExecuteTimeFilter", urlPatterns = "/*", asyncSupported = true)
public class ExecuteTimeFilter implements Filter {

	private static final Logger logger = Logger.getLogger(ExecuteTimeFilter.class.getName());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		chain.doFilter(request, response);
		stopWatch.stop();
		logger.info("execute time : " + stopWatch.getTime());
	}

	@Override
	public void destroy() {

	}
}