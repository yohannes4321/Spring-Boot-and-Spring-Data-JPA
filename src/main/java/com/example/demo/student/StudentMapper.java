package com.example.demo.student;

import com.example.demo.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {



    public Student toStudent(StudentDto dto){
        if (dto == null){
            throw new NullPointerException("The Student Dto Should not be  null");
        }
        var student=new Student();
        student.setFirstname(dto.firstName());
        student.setLastname(dto.lastName());
        student.setEmail(dto.email());
        var school=new School();
        school.setId(dto.schoolid());
        student.setSchool(school);
        return student;
    }
    public StudentResponseDto fromStudenttoStudnetResponse(Student student){
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }
}
