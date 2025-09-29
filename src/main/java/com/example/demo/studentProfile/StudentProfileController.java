package com.example.demo.studentProfile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentProfileController {


    public StudentProfileController(StudentProfileRepositery studentProfileRepositery) {
        this.studentProfileRepositery = studentProfileRepositery;
    }

    private StudentProfileRepositery studentProfileRepositery;
    @PostMapping("/student_profile")
    public StudentProfile studentProfile(@RequestBody StudentProfile studentProfile){
        return studentProfileRepositery.save(studentProfile);
    }
    @GetMapping("/student_profile")
    public List<StudentProfile> get_studentProfile(){
        return studentProfileRepositery.findAll();
    }


}
