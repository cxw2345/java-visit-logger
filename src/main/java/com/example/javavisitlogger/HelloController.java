package com.example.javavisitlogger; // 包名已修正

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final LogRepository logRepository;

    public HelloController(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @GetMapping("/hello")
    public String sayHello() {
        // 1. 存数据
        logRepository.save(new AccessLog("Java Spring Boot"));
        // 2. 查数量
        long count = logRepository.count();
        return "你好！我是 Java 容器。这是第 " + count + " 次访问数据库！";
    }
}