package com.pioneers.spring.controller.singleton;

import com.pioneers.spring.pattern.singleton.BillPughDbConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/singleton")
public class BillPughDbSingletonController {

    @GetMapping("billPughDbConnection")
    public String getEagerDbConnectionApi() {
        BillPughDbConnection connection = BillPughDbConnection.getInstance();
        connection.setConnectionString("Connection1");

        return connection.getConnectionString();
    }

    @GetMapping("billPughDbConnection2")
    public String getEagerDbConnection2Api() {
        BillPughDbConnection connection = BillPughDbConnection.getInstance();
        connection.setConnectionString("Connection2");

        return connection.getConnectionString();
    }
}
