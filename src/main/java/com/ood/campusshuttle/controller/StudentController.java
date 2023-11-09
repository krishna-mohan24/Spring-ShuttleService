package com.ood.campusshuttle.controller;

import com.ood.campusshuttle.model.Students;
import com.ood.campusshuttle.repository.StudentRepository;
import com.ood.campusshuttle.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/ip/student")
    public Object findStudent(@RequestParam(name = "id", required = false) Long id) throws Exception {
        Students student = studentService.getStudentById(id);

        if (student == null) {
            Exception e = new Exception("Service Unavailable. Enter a valid student id");
            throw e;

        }
        return student;
    }



}
