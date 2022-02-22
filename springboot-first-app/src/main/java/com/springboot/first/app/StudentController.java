package com.springboot.first.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost8080:/student
    @GetMapping("/student")
    public Student getStudent(){
        return new Student("Post", "Malone");
    }

    //http://localhost8080:/students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("John", "Wick"));
        studentList.add(new Student("Dwayne", "Johnson"));
        studentList.add(new Student("Nick", "Pop"));
        studentList.add(new Student("Ben", "Affleck"));
        studentList.add(new Student("Lily", "Collins"));
        return studentList;
    }

    //http://localhost8080:/student/LeBron/James
    @GetMapping("/student/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("firstName") String firstName,
                                       @PathVariable("lastName") String lastName){
        return new Student(firstName, lastName);
    }

    //http://localhost8080:/student/query?firstName=John&lastName=Doe
    @GetMapping("/student/query")
    public Student studentQueryVariable(@RequestParam(name = "firstName") String firstName,
                                        @RequestParam(name = "lastName") String lastName){
        return new Student(firstName, lastName);
    }
}
