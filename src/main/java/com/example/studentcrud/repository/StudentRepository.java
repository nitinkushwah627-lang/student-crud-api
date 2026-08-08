package com.example.studentcrud.repository;

import com.example.studentcrud.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);

    Student findByEmail(String email);

    List<Student> findByCourse(String course);

    List<Student> findByNameAndCourse(String name, String course); 

    @Query("SELECT s FROM Student s WHERE s.course=:course")
    List<Student> getStudentsByCourse(@Param("course") String course);

    
}