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

@WebServlet(value = "/calculadora")
public class App extends HttpServlet {
	private static final long serialVersionUID = 7560258824251863939L;
	private ApplicationContext ac = new AnnotationConfigApplicationContext(ConfiguracaoCalculadora.class);
	private Calculadora calculadora = (Calculadora) ac.getBean("calculadora");

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double a = Double.parseDouble(req.getParameter("valorA"));
		double b = Double.parseDouble(req.getParameter("valorB"));
		String operacao = req.getParameter("operacao");
		PrintWriter out = resp.getWriter();

		out.println("Resultado: " + calculadora.calcular(a, b, operacao));
		out.println("Histórico");
		calculadora.mostrarHistorico().forEach(op -> out.println(op.toString()));
	}
}
