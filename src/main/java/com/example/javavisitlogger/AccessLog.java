package com.example.javavisitlogger; // 注意：这里改成了你的实际包名

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "access_log")
public class AccessLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "log_time")
    public LocalDateTime logTime = LocalDateTime.now();

    public String source;

    public AccessLog() {}
    public AccessLog(String source) {
        this.source = source;
    }
}
