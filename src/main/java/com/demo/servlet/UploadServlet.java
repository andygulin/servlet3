package com.demo.servlet;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

@MultipartConfig(fileSizeThreshold = 1024, maxFileSize = Integer.MAX_VALUE, maxRequestSize = Integer.MAX_VALUE)
@WebServlet(name = "uploadServlet", urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 3573720494739616042L;

	private static final MultipartConfig config;

	private static final Logger logger = Logger.getLogger(UploadServlet.class.getName());

	static {
		config = UploadServlet.class.getAnnotation(MultipartConfig.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		logger.info(config.location());
		logger.info(String.valueOf(config.fileSizeThreshold()));
		logger.info(String.valueOf(config.maxFileSize()));
		logger.info(String.valueOf(config.maxRequestSize()));

		Part part = req.getPart("file");
		String header = part.getHeader("content-disposition");
		String fileName = StringUtils.substringBetween(header, "filename=\"", "\"");
		String ext = FilenameUtils.getExtension(fileName);
		String destFile = UUID.randomUUID().toString() + "." + ext;

		logger.info(fileName);
		logger.info(ext);
		logger.info(destFile);

		part.write(destFile);

	}

}
