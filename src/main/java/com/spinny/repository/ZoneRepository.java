package com.spinny.repository;

import com.spinny.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {
    Zone findByArea(String area);
}