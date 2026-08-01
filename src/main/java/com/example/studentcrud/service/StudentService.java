package com.example.studentcrud.service;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // Get All Students
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Add Student
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    // Get Student By ID
    public Student getStudentById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Update Student
    public Student updateStudent(Integer id, Student updatedStudent) {

    Student student = repository.findById(id).orElse(null);

    if (student == null) {
        return null;
    }

    student.setName(updatedStudent.getName());
    student.setEmail(updatedStudent.getEmail());
    student.setCourse(updatedStudent.getCourse());

    return repository.save(student);
    }

    // Delete Student
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }
}