package com.example.studentcrud.mapper;

import com.example.studentcrud.dto.StudentRequestDto;
import com.example.studentcrud.dto.StudentResponseDto;
import com.example.studentcrud.model.Student;

public class StudentMapper {

    // StudentRequestDto -> Student Entity
    public static Student toEntity(StudentRequestDto dto) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());

        return student;
    }

    // Student Entity -> StudentResponseDto
    public static StudentResponseDto toResponseDto(Student student) {

        StudentResponseDto dto = new StudentResponseDto();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setCourse(student.getCourse());

        return dto;
    }
}