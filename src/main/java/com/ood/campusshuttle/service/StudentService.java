package com.ood.campusshuttle.service;

import com.ood.campusshuttle.model.Students;
import com.ood.campusshuttle.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentService {


    private final StudentRepository studentRepository;

    public Students getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

}
