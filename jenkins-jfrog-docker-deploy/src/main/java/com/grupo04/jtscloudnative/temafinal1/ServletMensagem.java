package com.grupo04.jtscloudnative.temafinal1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/mensagem")
public class ServletMensagem extends HttpServlet {
	private static final long serialVersionUID = 2313526302176008576L;

	public String executarMensagem() {
		return "Hello, World";
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();

		out.println(executarMensagem());
		out.close();
	}
}
