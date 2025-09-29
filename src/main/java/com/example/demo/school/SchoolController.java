package com.example.demo.school;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    private SchoolService schoolService;

    @PostMapping("/schools")
    public SchoolDto create(@RequestBody School school){
        return schoolService.create(school);
    }
    @GetMapping("/schools")
    public List<SchoolDto> all_school(){
        return schoolService.all_school();
    }
    @GetMapping("/schools/{id}")
    public SchoolDto school_id(@RequestParam ("id")Integer id){
        return schoolService.school_id(id);
    } @DeleteMapping("/schools/{id}")
    public void delete_school_controller(@RequestParam ("id")Integer id){
         schoolService.delete_school(id);
    }
}
