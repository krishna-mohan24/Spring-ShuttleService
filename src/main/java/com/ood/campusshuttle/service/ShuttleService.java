package com.ood.campusshuttle.service;

import com.ood.campusshuttle.model.Location;
import com.ood.campusshuttle.model.Shuttle;
import com.ood.campusshuttle.model.Status;
import com.ood.campusshuttle.model.Students;
import com.ood.campusshuttle.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ood.campusshuttle.model.Shuttle.passengerList;

@Data
@Service
@AllArgsConstructor

public class ShuttleService {

    public Shuttle shuttle;
    public static String finalLocation = "College Place";
    private StudentRepository studentRepository;

    private static String updatedShuttleLocation = "";
    public String addPassenger(Students s) throws Exception {

        if (!passengerList.contains(s) && s.getStatus().equals("Idle")) {
            passengerList.add(s);
            s.setStatus(String.valueOf(Status.PickedUp));
            studentRepository.save(s);
            if (finalLocation.equals("College Place")) {
                return "Request successful. Estimated Wait Time is 0 minutes";
            } else {
                return "Request successful. Estimated Wait Time is " + (10 * passengerList.size()) + " minutes";
            }
        } else {
            return "Student is already present in the list";
        }
    }

    @Scheduled(fixedRate = 600000) // Executes every 10 minutes
    public void scheduler(){
        if(passengerList.isEmpty()){
            List<Students> studentsList=studentRepository.findAll();
            for(Students stu:studentsList){
                stu.setStatus(String.valueOf(Status.Idle));
                studentRepository.save(stu);
            }
            finalLocation = "College Place";
            Location.latitude = 43.0387;
            Location.longitude = -76.1337;
        }
    }

    @Scheduled(fixedRate = 1000)
    public void updatedShuttleLocation(){
        updatedShuttleLocation = "Shuttle is at location: "+finalLocation+"\nLatitude:" + Location.latitude +" Longitude:" + Location.longitude;
    }
    public String updateShuttleLocation() {
        return updatedShuttleLocation;
    }

    public String studentDropOff() {

        Students s1 = null;
        if(!passengerList.isEmpty()){
            s1 = passengerList.get(0);
            finalLocation = s1.getAddress();
            Location.latitude = s1.getLatitude();
            Location.longitude = s1.getLongitude();
            s1.setStatus(String.valueOf(Status.DroppedOff));
            studentRepository.save(s1);
            passengerList.remove(0);
        }

        if(s1!=null){
            return "Student:"+s1.getName()+" has been dropped at "+s1.getAddress()+"\nLatitude: "+s1.getLatitude()+" Longitude: "+s1.getLongitude();
        }
        else{
            return "Shuttle is empty";
        }
    }
}
