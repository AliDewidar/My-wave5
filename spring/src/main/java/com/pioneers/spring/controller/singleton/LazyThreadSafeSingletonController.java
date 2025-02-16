package com.pioneers.spring.controller.singleton;

import com.pioneers.spring.pattern.singleton.LazyThreadSafeDbConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/singleton")
public class LazyThreadSafeSingletonController {

    @GetMapping("getLazyThreadSafeDbConnection")
    public String getEagerDbConnectionApi() {
        LazyThreadSafeDbConnection connection = LazyThreadSafeDbConnection.getInstance();
        connection.setConnectionString("Connection1");

        return connection.getConnectionString();
    }

    @GetMapping("getLazyThreadSafeDbConnection2")
    public String getEagerDbConnection2Api() {
        LazyThreadSafeDbConnection connection = LazyThreadSafeDbConnection.getInstance();
        connection.setConnectionString("Connection2");

        return connection.getConnectionString();
    }
}
