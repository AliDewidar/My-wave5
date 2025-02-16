package com.pioneers.spring.controller.singleton;

import com.pioneers.spring.pattern.singleton.EnumDbConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/singleton")
public class EnumSingletonController {

    @GetMapping("getEnumDbConnection")
    public String getEagerDbConnectionApi() {
        EnumDbConnection connection = EnumDbConnection.getInstance();
        connection.setConnectionString("Connection1");

        return connection.getConnectionString();
    }

    @GetMapping("getEnumDbConnection2")
    public String getEagerDbConnection2Api() {
        EnumDbConnection connection = EnumDbConnection.getInstance();
        connection.setConnectionString("Connection2");

        return connection.getConnectionString();
    }
}
