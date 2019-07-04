package com.grupo04.jtscloudnative.temafinal2.songservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectionBD {
	private static String SENHA;
	private static String USUARIO;
	
	@Value("${USUARIO_BANCO}")
	public void setUsuario(String usuario) {
		ConnectionBD.USUARIO = usuario;
	}
	
	@Value("${SENHA_BANCO}")
	public void setSenha(String senha) {
		ConnectionBD.SENHA = senha;
	}
	
    public static Connection createConnection() throws SQLException {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/song", USUARIO, SENHA);
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro.getMessage());
        }
    }
}
