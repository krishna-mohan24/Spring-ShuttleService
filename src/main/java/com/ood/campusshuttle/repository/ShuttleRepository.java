package com.ood.campusshuttle.repository;

import com.ood.campusshuttle.model.Shuttle;
import com.ood.campusshuttle.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShuttleRepository extends JpaRepository<Students,Long> {

}
