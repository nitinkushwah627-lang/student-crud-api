package com.example.studentcrud.controller;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService service = new StudentService();

    @GetMapping
    public List<Student> getAllStudents() {

        return service.getAllStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        service.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
    return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, 
                          @RequestBody Student student) {
    service.updateStudent(id, student);
    }
    
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
    service.deleteStudent(id);
    }
}