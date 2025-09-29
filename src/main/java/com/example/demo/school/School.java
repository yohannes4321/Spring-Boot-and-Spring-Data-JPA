package com.example.demo.school;

import com.example.demo.student.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class School {
    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @OneToMany(
            mappedBy = "school"

    )
    @JsonManagedReference
    private List<Student> student;

    @Id
    @GeneratedValue
    private Integer id;
    private String address;

    public School(Integer id, String name,String address) {
        this.id = id;
        this.name = name;
        this.address=address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School() {
    }

    private String name;

}
