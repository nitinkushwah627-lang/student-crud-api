package com.example.studentcrud.service;

import java.util.List;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;

public class StudentService {
    
    private StudentRepository repository = new StudentRepository();


    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }


    public void addStudent(Student student) {
        repository.addStudent(student);
    }

    public Student getStudentById(int id) {
    return repository.getStudentById(id);
    
    }

    public void updateStudent(int id, Student student) {
    repository.updateStudent(id, student);
    }

    public void deleteStudent(int id) {
    repository.deleteStudent(id);
    }

    
}
