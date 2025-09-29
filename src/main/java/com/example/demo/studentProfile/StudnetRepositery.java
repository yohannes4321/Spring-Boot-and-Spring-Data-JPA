package com.example.demo.studentProfile;

import com.example.demo.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudnetRepositery extends JpaRepository<Student,Integer> {
    List<Student> findAllByFirstnameContaining(String p);
}
