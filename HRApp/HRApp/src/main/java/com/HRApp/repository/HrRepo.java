package com.HRApp.repository;

import com.HRApp.entity.Hr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HrRepo extends JpaRepository<Hr,String> {

    Hr findByEmail(String email);
}

