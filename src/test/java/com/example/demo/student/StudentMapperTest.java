package com.example.demo.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    private StudentMapper studentMapper;
    @Test
    public  void shouldMapStudentDtotoStudent(){
        StudentDto dto=new StudentDto(
                "john",
                "alex",
                "alemuyohannes960@gmail.com",
                1
        );

        Student student=studentMapper.toStudent(dto);
        assertEquals(dto.firstName(),student.getFirstname());
        assertEquals(dto.lastName(),student.getLastname());
        assertEquals(dto.email(),student.getEmail());
        assertEquals(dto.schoolid(),student.getSchool().getId());

    }
    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_Null(){
        ;
        var msg=assertThrows(NullPointerException.class,()-> studentMapper.toStudent(null));
        assertEquals("The Student Dto Should not be  null",msg.getMessage());

    }

    @BeforeEach
    void setUp() {
        studentMapper=new StudentMapper();
    }
}