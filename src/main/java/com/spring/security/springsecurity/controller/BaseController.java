package com.spring.security.springsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping(value = "/Hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }
}
