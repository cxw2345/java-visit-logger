package com.example.javavisitlogger; // 包名已修正

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<AccessLog, Long> {
}