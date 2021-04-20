package com.qa.repositories;

import com.qa.models.TeamRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository
        extends JpaRepository<TeamRecord, Long> {
}
