package com.example.demo.student;



import com.example.demo.studentProfile.StudnetRepositery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudnetRepositery studnetRepositery;
    private final StudentMapper studentMapper;

    public StudentService(StudnetRepositery studnetRepositery, StudentMapper studentMapper) {
        this.studnetRepositery = studnetRepositery;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto dto) {
        Student student = studentMapper.toStudent(dto);
        Student savedStudent = studnetRepositery.save(student);
        return studentMapper.fromStudenttoStudnetResponse(savedStudent);
    }


    public List<StudentResponseDto> getStudent() {
        List<Student> students = studnetRepositery.findAll();
        return students.stream()
                .map(studentMapper::fromStudenttoStudnetResponse)
                .collect(Collectors.toList());
    }


    public StudentResponseDto getStudentbyid(Integer id) {
        Optional<Student> studentOpt = studnetRepositery.findById(id);
        return studentOpt
                .map(studentMapper::fromStudenttoStudnetResponse)
                .orElse(null); // or throw exception based on your logic
    }  public void  deleteStudentbyid(Integer id) {
        studnetRepositery.deleteById(id);
    }


    public List<StudentResponseDto> getStudentbyname(String name) {
        List<Student> students = studnetRepositery.findAllByFirstnameContaining(name);
        return students.stream()
                .map(studentMapper::fromStudenttoStudnetResponse)
                .collect(Collectors.toList());
    }
}
