package com.pioneers.spring.controller;

import com.pioneers.spring.config.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beanCaller")
public class BeanCallerController {

    // Get the employee from Spring container.
    private final Employee employee;

    public BeanCallerController(Employee employee) {
        System.out.println("I am in the constructor of BeanCallerController");
        this.employee = employee;
//        Employee employee = employee;
//        BeanCallerController beanCallerController = new BeanCallerController(employee);
    }

    @GetMapping("getEmployee")
    public Employee getEmployeeApi() {
        employee.setName("Khaled");
        employee.setAge(30);
        employee.setDepartment("Development");
        return employee;
    }
}
