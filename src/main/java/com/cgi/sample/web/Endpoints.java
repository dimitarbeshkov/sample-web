/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgi.sample.web;

/**
 *
 * @author dimitar.beshkov
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import responses.DefaultResponse;

@RestController
@RequestMapping("person")
public class Endpoints {

    @Value("${default.name}")
    private String defaultName;
    @Value("${default.world}")
    private String defaultWorld;

    @RequestMapping(
            value = {"greeting"},
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> greeting(@RequestParam(value = "name", defaultValue = "Jon Doe") String name,
            @RequestParam(value = "world", defaultValue = "Alpha 3122") String world) {

        DefaultResponse response = new DefaultResponse();
        response.setBody("Yo Yo Yo! This is " + defaultName + " from " + defaultWorld + ", How are things " + name + " in " + world + "?");
        return new ResponseEntity<DefaultResponse>(response, HttpStatus.ACCEPTED);
    }
}
