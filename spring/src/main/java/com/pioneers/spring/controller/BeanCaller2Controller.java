package com.pioneers.spring.controller;

import com.pioneers.spring.config.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beanCaller2")
public class BeanCaller2Controller {

    private final Employee employee;

    public BeanCaller2Controller(Employee employee) {
        System.out.println("I am in the constructor of BeanCaller2Controller");
        this.employee = employee;
    }

    @RequestMapping("getEmployee")
    public Employee getEmployeeApi() {
        return employee;
    }
}
