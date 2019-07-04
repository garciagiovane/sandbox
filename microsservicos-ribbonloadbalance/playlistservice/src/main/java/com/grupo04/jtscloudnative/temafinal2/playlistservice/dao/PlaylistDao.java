package com.grupo04.jtscloudnative.temafinal2.playlistservice.dao;

import com.grupo04.jtscloudnative.temafinal2.playlistservice.domain.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDao {
	public Playlist searchById(int id) {

		try (Connection connection = ConectionBD.createConnection()) {
			String query = "SELECT * FROM playlist WHERE id like ?";

			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, id);

			ResultSet resultSet = preparedStmt.executeQuery();
			List<Integer> songs = new ArrayList<>();
			
			while (resultSet.next()) {
				songs.add(resultSet.getInt("id_song"));
				if (resultSet.isLast()) {
					Playlist playlist = new Playlist(resultSet.getInt("id"), songs);
					return playlist;
				}
			}
			throw new RuntimeException("Playlist not found!");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
	}
}