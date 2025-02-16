package com.pioneers.spring.controller.singleton;

import com.pioneers.spring.pattern.singleton.EagerDbConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/singleton")
public class EagerSingletonController {

    @GetMapping("getEagerDbConnection")
    public String getEagerDbConnectionApi() {
        EagerDbConnection connection = EagerDbConnection.getInstance();
        connection.setConnectionString("Connection1");

        return connection.getConnectionString();
    }

    @GetMapping("getEagerDbConnection2")
    public String getEagerDbConnection2Api() {
        EagerDbConnection connection = EagerDbConnection.getInstance();
        connection.setConnectionString("Connection2");

        return connection.getConnectionString();
    }
}
