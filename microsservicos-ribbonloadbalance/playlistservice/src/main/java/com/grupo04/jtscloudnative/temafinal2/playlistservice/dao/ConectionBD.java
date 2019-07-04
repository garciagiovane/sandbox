package com.grupo04.jtscloudnative.temafinal2.playlistservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class ConectionBD {
	private static String usuario;
	private static String senha;
	
	@Value("${SENHA_BANCO}")
	public void setSenha(String senha) {
		ConectionBD.senha = senha;
	}
	
	@Value("${USUARIO_BANCO}")
	public void setUsuario(String usuario) {
		ConectionBD.usuario = usuario;
	}
	
    public static Connection createConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/playlist", usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}