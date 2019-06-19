package com.garciagiovane.cloud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.garciagiovane.cloud.conexao.ConexaoBanco;

public class TesteDAO {
	public boolean cadastrar(String nome, int id) {
		String sqlCadastro = "INSERT INTO tabela (nome, id) VALUES (?, ?)";
		try (Connection conexao = new ConexaoBanco().inicializarConexao()) {
			PreparedStatement sql = conexao.prepareStatement(sqlCadastro);
			sql.setString(1, nome);
			sql.setInt(2, id);

			sql.execute();
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
