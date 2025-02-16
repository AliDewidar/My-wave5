package com.pioneers.spring.controller;

import com.pioneers.spring.config.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/context")
public class ContextController {
    private final ApplicationContext context;

    // Tightly Coupled
    public ContextController() {
        context = new ApplicationContext();
    }

    // TODO: Create an API that fetch the IP of the ApplicationContext class.'
    @GetMapping("getip")
    public String getIpApi() {
        return context.getIp();
    }

    @PutMapping("ip/{ip}")
    public ApplicationContext changeIpApi(@PathVariable String ip) {
        context.setIp(ip);
        return context;
    }

    @PutMapping("port")
    public ApplicationContext changePortApi(@RequestParam int port) {
        context.setPort(port);
        return context;
    }

    @PutMapping("dbName/{dbName}")
    public ApplicationContext changeDbNameApi(@PathVariable String dbName) {
        context.setDbName(dbName);
        return context;
    }
}
