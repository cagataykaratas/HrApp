package com.HRApp.lib.dto;

import com.HRApp.entity.Job;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
public class ApplicantDto {

    private String title;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String comment;
    private List<Job> jobs;
}
