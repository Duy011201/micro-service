package com.starship.microservice.module.sysUser.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PingController {

    @GetMapping("/ping")
    public Mono<String> hello() {
        return Mono.just("Hello, ping!");
    }
}
