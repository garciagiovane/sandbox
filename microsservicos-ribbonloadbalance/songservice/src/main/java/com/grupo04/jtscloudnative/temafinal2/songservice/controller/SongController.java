package com.grupo04.jtscloudnative.temafinal2.songservice.controller;

import com.grupo04.jtscloudnative.temafinal2.songservice.service.SongCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

    @GetMapping(value = "/song/{id}", produces = "application/json")
    public ResponseEntity<String> getSong(@PathVariable("id") int id) {
        return new ResponseEntity<String>(new SongCommand(id).execute(), HttpStatus.OK);
    }
    
    @GetMapping(value = "/healthcheck", produces = "application/json")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
