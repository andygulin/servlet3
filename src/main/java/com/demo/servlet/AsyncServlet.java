package com.demo.servlet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "asyncServlet", urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	private static final long serialVersionUID = 7113818283363751360L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("begin...");
		resp.getWriter().flush();

		final AsyncContext context = req.startAsync();
		context.setTimeout(Long.MAX_VALUE);
		context.start(() -> {
			try {
				TimeUnit.SECONDS.sleep(3L);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				context.getResponse().getWriter().println("async...");
				context.getResponse().getWriter().flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
			context.complete();
		});

		resp.getWriter().println("end...");
		resp.getWriter().flush();
	}
}
