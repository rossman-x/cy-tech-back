package com.cytech.cytechback.student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController implements IStudentController{

    @Override
    @GetMapping(path = "list")
    public ResponseEntity<List<StudentDTO>> getStudents() {
        return ResponseEntity.ok().body();
    }
}
