package com.HRApp.repository;

import com.HRApp.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface JobRepo extends JpaRepository<Job,String> {

    List<Job> findByTitle(String title);
    Job findById(UUID id);
}
