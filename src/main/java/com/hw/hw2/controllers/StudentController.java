package com.hw.hw2.controllers;


import com.hw.hw2.models.Student;
import com.hw.hw2.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public String viewStudents(Model model){
        studentService.addStudent(new Student("Ivan","Ivanov",24, new ArrayList<>(Arrays.asList(5,3,4,5))));
        studentService.addStudent(new Student("Kate","Ivanova",23, new ArrayList<>(Arrays.asList(5,5,5,5))));
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @PostMapping()
    public String addStudent(Student s, Model model){
        studentService.addStudent(s);
        model.addAttribute("students", studentService.findAll());
        return "students";
    }


    @GetMapping("/{lastName}")
    public String viewAverageGrades(@PathVariable String lastName, Model model){
        Student student = studentService.getStudentByLastName(lastName);
        Double average = studentService.getAverageGrades(student);
        model.addAttribute("averageGrades",average.toString());
        return "average";
    }
}
