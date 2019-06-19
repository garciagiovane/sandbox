package com.garciagiovane.cloud.calculadora;

import com.garciagiovane.cloud.configuracao.ConfiguracaoCalculadora;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/calculadora", name = "Calculadora")
public class App extends HttpServlet {
	private static final long serialVersionUID = 7560258824251863939L;
	private ApplicationContext ac = new AnnotationConfigApplicationContext(ConfiguracaoCalculadora.class);
	private Calculadora calculadora = (Calculadora) ac.getBean("calculadora");

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		double a = Double.parseDouble(req.getParameter("valorA"));
		double b = Double.parseDouble(req.getParameter("valorB"));
		String operacao = req.getParameter("operacao");
		PrintWriter out = resp.getWriter();

		out.println(htmlResponseInit(a, b, operacao));
		calculadora.mostrarHistorico().forEach(op -> out.println(op.toString()+ "<br>"));
		out.println(htmlResponseFinal());
	}
	
	private String htmlResponseInit(double a, double b, String operacao) {
		return "<!doctype>\n" +
				"<head>" +
				"<title>Calculadora</title>" +
				"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n" +
				"          integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">" +
				"<style>\n" +
				"        .form {\n" +
				"            width: 400px;\n" +
				"            margin: 0 auto;\n" +
				"        }\n" +
				"    </style>" +
				"</head>\n" +
				"<body>\n" +
				"<div class=\"container\">" +
				"<div class=\"form\">" +
				"<h3>Calculadora com Spring</h3>" +
				"<p>Resultado: " + calculadora.calcular(a, b, operacao) + "</p>" +
				"<p>Histórico</p>";
	}
	
	private String htmlResponseFinal() {
		return "<p><a href=\"/tema04-1.0-SNAPSHOT/\">novo cálculo</a>\n</p>" +
				"</div>" +
		"</div>\n" +
		"</body>\n" +
		"</html>";
	}
}
