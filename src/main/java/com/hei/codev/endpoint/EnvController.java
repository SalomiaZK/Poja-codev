package com.hei.codev.endpoint;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {
    @GetMapping("/prod-env")
    public String preprodEnv() {
        return System.getenv("SECRET_KEY");
    }
}