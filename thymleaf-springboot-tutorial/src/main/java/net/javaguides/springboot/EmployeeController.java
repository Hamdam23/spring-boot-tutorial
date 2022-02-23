package net.javaguides.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @GetMapping("/iteration")
    public String iteration(Model model) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Wick", "wick@gmail.com"));
        employees.add(new Employee("Post", "Malone", "john@gmail.com"));
        employees.add(new Employee("Tom", "Cruise", "tom@gmail.com"));
        employees.add(new Employee("Tony", "Stark", "tony@gmail.com"));
        model.addAttribute("employees", employees);
        return "iteration";
    }
}
