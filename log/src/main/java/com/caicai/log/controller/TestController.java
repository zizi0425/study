package com.caicai.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @GetMapping("/error")
    public ResponseEntity<String> error() {
        log.error("error --- ");
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/debug")
    public ResponseEntity<String> debug() {
        log.debug("debug --- ");
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/info")
    public ResponseEntity<String> info() {
        log.info("info --- ");
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/warn")
    public ResponseEntity<String> warn() {
        log.warn("warn --- ");
        return ResponseEntity.ok("ok");
    }
}
