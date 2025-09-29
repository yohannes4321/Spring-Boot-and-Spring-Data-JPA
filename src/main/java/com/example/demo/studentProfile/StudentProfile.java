package com.example.demo.studentProfile;

import com.example.demo.student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class StudentProfile {
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @OneToOne
    @JoinColumn(name="student_id")
    @JsonBackReference
    private Student student;

    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return id;
    }

    public StudentProfile() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }



    private String bio;

}
