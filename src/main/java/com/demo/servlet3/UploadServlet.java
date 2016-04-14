package com.demo.servlet3;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

@MultipartConfig(fileSizeThreshold = 1024, location = "/tmp", maxFileSize = Integer.MAX_VALUE, maxRequestSize = Integer.MAX_VALUE)
@WebServlet(name = "uploadServlet", urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 3573720494739616042L;

	private static final MultipartConfig config;

	static {
		config = UploadServlet.class.getAnnotation(MultipartConfig.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		System.out.println(config.location());
		System.out.println(config.fileSizeThreshold());
		System.out.println(config.maxFileSize());
		System.out.println(config.maxRequestSize());

		Part part = req.getPart("file");
		String header = part.getHeader("content-disposition");
		String fileName = StringUtils.substringBetween(header, "filename=\"",
				"\"");
		String ext = FilenameUtils.getExtension(fileName);
		String destFile = UUID.randomUUID().toString() + "." + ext;

		System.out.println(fileName);
		System.out.println(ext);
		System.out.println(destFile);
		
		part.write(destFile);

	}

}
