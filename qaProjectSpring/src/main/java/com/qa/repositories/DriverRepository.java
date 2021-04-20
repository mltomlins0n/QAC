package com.qa.repositories;

import com.qa.models.DriverRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository
        extends JpaRepository<DriverRecord, Long> {
}
