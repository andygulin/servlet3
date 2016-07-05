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

@WebFilter(filterName = "ExecuteTimeFilter", urlPatterns = "/*")
public class ExecuteTimeFilter implements Filter {

	private static final Logger logger = Logger.getLogger(ExecuteTimeFilter.class.getName());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long start = System.currentTimeMillis();
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		logger.info("execute time : " + (end - start));
	}

	@Override
	public void destroy() {

	}

}
