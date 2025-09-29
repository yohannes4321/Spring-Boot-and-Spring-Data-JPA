package com.example.demo.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    private StudentService studentService;

    @PostMapping("/student")
    public StudentResponseDto student_add(@Valid @RequestBody StudentDto studentDto){
       return studentService.saveStudent(studentDto);
    }
    @GetMapping("/student")
    public List<StudentResponseDto> getStudent(){
       return studentService.getStudent();
    }

    @GetMapping("/student/{id}")
    public StudentResponseDto getStudent(@RequestParam Integer id ){
        return studentService.getStudentbyid(id);
    }@GetMapping("/student/{name}")
    public List <StudentResponseDto> getStudent(@RequestParam String name){
        return studentService.getStudentbyname(name);
    }
    @DeleteMapping("/student/{id}")
    public void  deleteStudent(@RequestParam Integer id){
        studentService.deleteStudentbyid(id);
    }

    //only the important information is entered to saved

@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp){
        var errors=new HashMap<String,String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error ->{
                    var fieldName= ((FieldError)error).getField();
                    var error_message=error.getDefaultMessage();
                    errors.put(fieldName,error_message);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

}
}
