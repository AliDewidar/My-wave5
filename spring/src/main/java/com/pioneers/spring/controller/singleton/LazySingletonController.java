package com.pioneers.spring.controller.singleton;

import com.pioneers.spring.pattern.singleton.LazyDbConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/singleton")
public class LazySingletonController {

    @GetMapping("getLazyDbConnection")
    public String getEagerDbConnectionApi() {
        LazyDbConnection connection = LazyDbConnection.getInstance();
        connection.setConnectionString("Connection1");

        return connection.getConnectionString();
    }

    @GetMapping("getLazyDbConnection2")
    public String getEagerDbConnection2Api() {
        LazyDbConnection connection = LazyDbConnection.getInstance();
        connection.setConnectionString("Connection2");

        return connection.getConnectionString();
    }
}
