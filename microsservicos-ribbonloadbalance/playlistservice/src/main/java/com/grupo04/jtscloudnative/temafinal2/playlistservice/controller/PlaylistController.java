package com.grupo04.jtscloudnative.temafinal2.playlistservice.controller;

import com.grupo04.jtscloudnative.temafinal2.playlistservice.service.PlaylistCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistController {

    @GetMapping(value = "/playlist/{id}", produces = "application/json")
    public ResponseEntity<String> getPlaylist(@PathVariable("id") int id) {
        return new ResponseEntity<String>(new PlaylistCommand(id).execute(), HttpStatus.OK);
    }
}
