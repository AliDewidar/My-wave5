package com.pioneers.spring.controller;

import com.pioneers.spring.model.dto.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping(value = "welcome")
    public String welcomeApi() {
        return "Welcome to Tech Pioneers Hub with Spring Boot";
    }

    // Sending data from the client using Path Variable.
    @GetMapping("welcomeByName/{name}")
    public ResponseEntity<String> welcomeStudentApi(@PathVariable(value = "name") String myName) {
        return ResponseEntity.status(HttpStatus.OK)
                .body("<h1>Welcome " + myName + " to Tech Pioneers Hub with Spring Boot<h1>");
    }

    // Sending data from the client using Path Variable and Request Parameter.
    @GetMapping("welcomeByNameAgeGender/{name}")
    public String welcomeByNameAgeGenderApi(
            @PathVariable String name,
            @RequestParam(name = "age") int myAge,
            @RequestParam(name = "gender") String gender
    ) {
        return "<h1>Welcome " + name + " to Pioneers Hub with Spring Boot with Age: " + myAge
                + " and the gender is: " + gender + "<h1>";
    }

    // Sending data from the client using Request Body
    @PutMapping("increaseAge")
    public Teacher increaseTeacherApi(@RequestBody Teacher teacher) {
        teacher.setAge(teacher.getAge() + 1);
        teacher.getAddress().setCity("Nasr City");
        System.out.println("teacher = " + teacher);
        return teacher;
    }


}
