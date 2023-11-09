package com.ood.campusshuttle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students {

    @Id
    private long id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private String status;


    public String toString(){
        return this.id+" "+this.name +" "+this.address;
    }

}
