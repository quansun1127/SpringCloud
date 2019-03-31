package com.quansun.springcloud.chapter2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @RequestMapping(value = "/hello")
  public String index() {
    return "Hello Spring Boot, My name is quansun.";
  }
}
