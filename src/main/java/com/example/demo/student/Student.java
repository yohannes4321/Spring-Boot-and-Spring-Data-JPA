package com.example.demo.student;
import com.example.demo.studentProfile.StudentProfile;
import com.example.demo.school.School;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="T_studnet")
public class Student {
    @ManyToOne
    @JoinColumn(

            name="school_id"
    )
    @JsonBackReference
    private School school;


    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    @OneToOne(
    )
    @JoinColumn(name="studentProfile_id")
    @JsonManagedReference
    private StudentProfile studentProfile;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }




    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="c_fname")
    private String firstname;
    private String lastname;

    public Student() {
    }
    @Column(unique = true)
    private String email;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public Student( String firstname, String lastname, String email, Integer age) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }




}
