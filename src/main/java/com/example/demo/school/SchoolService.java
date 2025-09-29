package com.example.demo.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private SchoolRepositery schoolRepositery;
    private schoolMapper schoolMapper;
    @Autowired
    public SchoolService(SchoolRepositery schoolRepositery, schoolMapper schoolMapper) {
        this.schoolRepositery = schoolRepositery;
        this.schoolMapper = schoolMapper;
    }

    public SchoolService() {
    }

    public SchoolDto create(School school){
        var school_data=schoolRepositery.save(school);
        return schoolMapper.change_School_Schooldto(school_data);}
    public List<SchoolDto> all_school(){
        return schoolRepositery.findAll().stream().map(schoolMapper::change_School_Schooldto).collect(Collectors.toList());
    }
    public SchoolDto school_id(Integer id){
        return schoolRepositery.findById(id).map(schoolMapper::change_School_Schooldto).orElse(null);
    }  public void delete_school(Integer id){
        schoolRepositery.deleteById(id);
    }
}
