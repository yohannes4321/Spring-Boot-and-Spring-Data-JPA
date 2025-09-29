package com.example.demo.student;

import com.example.demo.studentProfile.StudnetRepositery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudnetRepositery studnetRepositery;

    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student() {
        StudentDto dto = new StudentDto("John", "Alex", "johnalex@gmail.com", 20);
        Student student = new Student("John", "Alex", "johnalex@gmail.com", 20);
        StudentResponseDto studentResp = new StudentResponseDto("John", "Alex", "johnalex@gmail.com");

        // Mock dependencies before calling the service
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(studnetRepositery.save(student)).thenReturn(student);
        when(studentMapper.fromStudenttoStudnetResponse(student)).thenReturn(studentResp);

        // When
        StudentResponseDto result = studentService.saveStudent(dto);

        // Then
        assertEquals(dto.firstName(), result.firstName());
        assertEquals(dto.lastName(), result.lastName());
        assertEquals(dto.email(), result.email());

        verify(studentMapper, times(1)).toStudent(dto);
        verify(studnetRepositery, times(1)).save(student);
        verify(studentMapper, times(1)).fromStudenttoStudnetResponse(student);
    }

    @Test
    public void should_return_all_students() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Alex", "alex@gmail.com", 20));

        List<StudentResponseDto> studentsResponses = new ArrayList<>();
        studentsResponses.add(new StudentResponseDto("John", "Alex", "alex@gmail.com"));

        when(studnetRepositery.findAll()).thenReturn(students);
        when(studentMapper.fromStudenttoStudnetResponse(any(Student.class)))
                .thenReturn(studentsResponses.get(0));

        List<StudentResponseDto> result = studentService.getStudent();

        assertEquals(studentsResponses.size(), result.size());
        verify(studnetRepositery, times(1)).findAll();
    }

    @Test
    public void get_student_by_id() {
        Integer studentId = 1;
        Student student = new Student("John", "Alex", "johnalex@gmail.com", 20);
        StudentResponseDto studentResp = new StudentResponseDto("John", "Alex", "johnalex@gmail.com");

        when(studnetRepositery.findById(studentId)).thenReturn(Optional.of(student));
        when(studentMapper.fromStudenttoStudnetResponse(student)).thenReturn(studentResp);

        StudentResponseDto result = studentService.getStudentbyid(studentId);

        assertEquals(studentResp.firstName(), result.firstName());
        assertEquals(studentResp.lastName(), result.lastName());
        assertEquals(studentResp.email(), result.email());

        verify(studnetRepositery, times(1)).findById(studentId);
        verify(studentMapper, times(1)).fromStudenttoStudnetResponse(student);
    }

    @Test
    public void get_student_by_name() {
        String name = "John";
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Alex", "johnalex@gmail.com", 20));

        StudentResponseDto studentResp = new StudentResponseDto("John", "Alex", "johnalex@gmail.com");

        when(studnetRepositery.findAllByFirstnameContaining(name)).thenReturn(students);
        when(studentMapper.fromStudenttoStudnetResponse(any(Student.class))).thenReturn(studentResp);

        List<StudentResponseDto> result = studentService.getStudentbyname(name);

        assertEquals(students.size(), result.size());
        verify(studnetRepositery, times(1)).findAllByFirstnameContaining(name);
    }
}
