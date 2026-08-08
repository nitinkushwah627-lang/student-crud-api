package com.example.studentcrud.controller;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;

import com.example.studentcrud.dto.StudentRequestDto;
import com.example.studentcrud.dto.StudentResponseDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return service.getStudentById(id);
    }

    @GetMapping("/name/{name}")
    public List<Student> getStudentsByName(@PathVariable String name) {
        return service.getStudentsByName(name);
    }

    @GetMapping("/email/{email}")
    public Student getStudentByEmail(@PathVariable String email) {
        return service.getStudentByEmail(email);
    }

    @GetMapping("/course")
    public List<Student> getStudentsByCourse(@RequestParam String course) {
        return service.getStudentsByCourse(course);
    }

    @GetMapping("/search")
    public List<Student> getStudentsByNameAndCourse(@RequestParam String name,
                                                    @RequestParam String course) {
        return service.getStudentsByNameAndCourse(name, course);
    }

    @PostMapping
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto dto) {
         return service.addStudent(dto);
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(@PathVariable Integer id,
                                            @Valid @RequestBody StudentRequestDto dto) {
       return service.updateStudent(id, dto);
}

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
    }

    // Pagination and Sorting
    @GetMapping("/page")
    public Page<Student> getStudents(@RequestParam int page,
                                        @RequestParam int size) {
        return service.getStudents(page, size);
        } 
    
    // Students Sorted By Name Ascending
    @GetMapping("/sort/name/asc")
    public List<Student> getStudentsSortedByNameAsc() {
    return service.getStudentsSortedByNameAsc();
    }

    // Students Sorted By Name Descending
    @GetMapping("/sort/name/desc")
    public List<Student> getStudentsSortedByNameDesc() {
    return service.getStudentsSortedByNameDesc();
    }

    //  Students Sorted By Email Ascending
    @GetMapping("/sort/email/asc")
    public List<Student> getStudentsSortedByEmailAsc() {
    return service.getStudentsSortedByEmailAsc();
    }

    //  Students Sorted By Email Descending
    @GetMapping("/sort/email/desc")
    public List<Student> getStudentsSortedByEmailDesc() {
    return service.getStudentsSortedByEmailDesc();
    }

    //  Students Sorted By Course Ascending
    @GetMapping("/sort/course/asc")
    public List<Student> getStudentsSortedByCourseAsc() {
    return service.getStudentsSortedByCourseAsc();
    }

    //  Students Sorted By Course Descending
    @GetMapping("/sort/course/desc")
    public List<Student> getStudentsSortedByCourseDesc() {
    return service.getStudentsSortedByCourseDesc();
    }

    // Students Sorted By ID Ascending
    @GetMapping("/sort/id/asc")
    public List<Student> getStudentsSortedByIdAsc() {
    return service.getStudentsSortedByIdAsc();
    }

    // Students Sorted By ID Descending
    @GetMapping("/sort/id/desc")
    public List<Student> getStudentsSortedByIdDesc() {
    return service.getStudentsSortedByIdDesc();
    }
}