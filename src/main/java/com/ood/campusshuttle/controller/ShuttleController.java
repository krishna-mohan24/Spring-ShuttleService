package com.ood.campusshuttle.controller;

import com.ood.campusshuttle.model.Shuttle;
import com.ood.campusshuttle.model.Status;
import com.ood.campusshuttle.model.Students;

import com.ood.campusshuttle.repository.ShuttleRepository;
import com.ood.campusshuttle.repository.StudentRepository;
import com.ood.campusshuttle.service.ShuttleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShuttleController {

    private final ShuttleService shuttleService;
    private final StudentRepository studentRepository;


    @PostMapping("/ip/addPassenger")
    public String addPassenger(@RequestParam long id,@RequestParam String address) throws Exception {
        Students student = studentRepository.getReferenceById(id);
        Students s = new Students(id,student.getName(),address,student.getLatitude(),student.getLongitude(),student.getStatus());
        return shuttleService.addPassenger(s);
    }

    @GetMapping("/ip/passengerList")
    public List<Students> passengerList(){
        return Shuttle.passengerList;
    }

    @PostMapping ("/ip/dropOff")
    public String studentDropOff(){
        return shuttleService.studentDropOff();
    }

    @GetMapping("/ip/shuttleLocation")
    public String shuttleLocation(){
        return shuttleService.updateShuttleLocation();
    }

}

