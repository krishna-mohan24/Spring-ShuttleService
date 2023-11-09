package com.ood.campusshuttle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;



@Component
@Data
@AllArgsConstructor
public class Shuttle {

    public static ArrayList<Students> passengerList = new ArrayList<Students>();

}
