package com.vijay.spark.application.controller;

import com.vijay.spark.application.entity.WordCount;
import com.vijay.spark.application.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@Controller
public class ApiController {
    @Autowired
    CountService countService;

    @RequestMapping("/wordcount")
    public ResponseEntity<Map<String, Long>> words() {
        return new ResponseEntity<>(countService.count(), HttpStatus.OK);
    }
}
