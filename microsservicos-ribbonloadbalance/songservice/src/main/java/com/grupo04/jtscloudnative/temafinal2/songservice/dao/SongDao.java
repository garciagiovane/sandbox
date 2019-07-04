package com.grupo04.jtscloudnative.temafinal2.songservice.dao;

import com.grupo04.jtscloudnative.temafinal2.songservice.domain.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SongDao {
	public Song searchById(int id) {
		try (Connection connection = ConnectionBD.createConnection()) {
			String query = "SELECT * FROM song WHERE id like ?";

			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet resultSet = preparedStmt.executeQuery();

			if (resultSet.first()) {
				Song song = new Song();
				song.setId(resultSet.getInt("id"));
				song.setTitle(resultSet.getString("title"));
				return song;
			}
			throw new RuntimeException("song not found");
		} catch (SQLException sqlError) {
			throw new RuntimeException(sqlError.getMessage());
		}
	}
}