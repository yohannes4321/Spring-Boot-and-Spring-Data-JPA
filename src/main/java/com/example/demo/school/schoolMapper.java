package com.example.demo.school;

import org.springframework.stereotype.Service;

@Service
public class schoolMapper {

    public SchoolDto change_School_Schooldto(School school){
        var schooldto=new SchoolDto(
                school.getName()
        );
        return schooldto;
    }
}
