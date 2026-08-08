package com.example.studentcrud.service;
import com.example.studentcrud.exception.ResourceNotFoundException;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.studentcrud.dto.StudentRequestDto;
import com.example.studentcrud.dto.StudentResponseDto;
import com.example.studentcrud.mapper.StudentMapper;

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
    public StudentResponseDto addStudent(StudentRequestDto dto) {

    Student student = StudentMapper.toEntity(dto);

    Student savedStudent = repository.save(student);

    return StudentMapper.toResponseDto(savedStudent);

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
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));
    }

    public List<Student> getStudentsByNameAndCourse(String name, String course) {
        return repository.findByNameAndCourse(name, course);
    }

    // Update Student
    public StudentResponseDto updateStudent(
        Integer id,
        StudentRequestDto dto) {

            Student student = repository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Student not found with ID: " + id
                    )
            );

    student.setName(dto.getName());
    student.setEmail(dto.getEmail());
    student.setCourse(dto.getCourse());

    Student updatedStudent = repository.save(student);

    return StudentMapper.toResponseDto(updatedStudent);
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