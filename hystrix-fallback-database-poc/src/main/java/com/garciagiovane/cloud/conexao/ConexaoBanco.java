package com.garciagiovane.cloud.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	public Connection inicializarConexao() throws SQLException {
		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/teste", "root", "");
		} catch (SQLException erroSQL) {
			erroSQL.printStackTrace();
		}
		return conexao;
	}
}
