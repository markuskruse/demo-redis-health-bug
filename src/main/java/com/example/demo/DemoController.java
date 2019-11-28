package com.example.demo;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  public static final String MESSAGE = "message";

  @Autowired
  private StringRedisTemplate redisTemplate;

  @GetMapping(path = "/hello")
  public Map hello() {
    return Map.of(MESSAGE, redisTemplate.opsForValue().get(MESSAGE));
  }

  @PostMapping(path = "/hello")
  public void hello(Map payload) {
    String message = (String) payload.get(MESSAGE);
    redisTemplate.opsForValue().set(MESSAGE, message);
  }

}
