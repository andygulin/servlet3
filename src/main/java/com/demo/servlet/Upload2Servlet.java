package com.demo.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;

@WebServlet(name = "upload2Servlet", urlPatterns = "/upload2")
public class Upload2Servlet extends HttpServlet {

	private static final long serialVersionUID = 3573720494739616042L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String base64 = req.getParameter("image");
		String name = req.getParameter("name");
		final String STR_BASE64_PREFIX = "data:image/png;base64,";
		if (base64.indexOf(STR_BASE64_PREFIX) != ArrayUtils.INDEX_NOT_FOUND) {
			base64 = base64.substring(base64.lastIndexOf(STR_BASE64_PREFIX) + STR_BASE64_PREFIX.length());
			System.out.println(base64);
		}
		byte[] data = Base64.decodeBase64(base64);
		String fileName = UUID.randomUUID().toString();
		String ext = FilenameUtils.getExtension(name);
		String destFile = fileName + "." + ext;
		FileUtils.writeByteArrayToFile(new File(destFile), data);
		PrintWriter out = resp.getWriter();
		out.print(destFile);
		out.flush();
		out.close();
	}
}
