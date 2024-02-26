package com.hw.hw2.services;

import com.hw.hw2.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> findAll(){
        return students;
    }

    public Double getAverageGrades(Student student){
        return student.getGrades().stream().mapToDouble(a -> a).average().getAsDouble();
    }

    public Student getStudentByLastName(String lastName){
        return (Student) students.stream().filter(s -> s.getLastName().equals(lastName)).toArray()[0];
    }
}
