package com.example.studentcrud.service;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    // Get Students By Name
    public List<Student> getStudentsByName(String name) {
        return repository.findByName(name);
    }

    // Get Student By Email
    public Student getStudentByEmail(String email) {
        return repository.findByEmail(email);
    }

    // Get Students By Course
    public List<Student> getStudentsByCourse(String course) {
        return repository.getStudentsByCourse(course);
    }

    // Get Student By ID
    public Student getStudentById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Student> getStudentsByNameAndCourse(String name, String course) {
        return repository.findByNameAndCourse(name, course);
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

    // Get Students with Pagination
    public Page<Student> getStudents(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return repository.findAll(pageable);
    }

    // Students Sorted By Name Ascending
    public List<Student> getStudentsSortedByNameAsc() {
    return repository.findAll(Sort.by("name"));
    }

    // Students Sorted By Name Descending
    public List<Student> getStudentsSortedByNameDesc() {
    return repository.findAll(Sort.by(Sort.Direction.DESC, "name"));
    }

    // Students Sorted By Email Ascending
    public List<Student> getStudentsSortedByEmailAsc() {
    return repository.findAll(Sort.by("email"));
    }

    // Students Sorted By Email Descending
    public List<Student> getStudentsSortedByEmailDesc() {
    return repository.findAll(Sort.by(Sort.Direction.DESC, "email"));
    }

    // Students Sorted By Course Ascending
    public List<Student> getStudentsSortedByCourseAsc() {
    return repository.findAll(Sort.by("course"));
    }

    // Students Sorted By Course Descending
    public List<Student> getStudentsSortedByCourseDesc() {
    return repository.findAll(Sort.by(Sort.Direction.DESC, "course"));
    }

    // Students Sorted By ID Ascending
    public List<Student> getStudentsSortedByIdAsc() {
    return repository.findAll(Sort.by("id"));
    }

    // Students Sorted By ID Descending
    public List<Student> getStudentsSortedByIdDesc() {
    return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    // get Students with Pagination and Sorting
    public Page<Student> getStudents(int page, int size, String sortBy) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
    return repository.findAll(pageable);
    }
     

}