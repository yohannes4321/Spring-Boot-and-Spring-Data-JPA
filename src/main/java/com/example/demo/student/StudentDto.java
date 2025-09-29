package com.example.demo.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "First Name Should not be Empty")
        String firstName,
        @NotEmpty(message = "Last Name Should not be Empty")
        String lastName,
        @NotEmpty(message = "Email Should not be Empty ")
        String email,
        Integer schoolid

) {


}
