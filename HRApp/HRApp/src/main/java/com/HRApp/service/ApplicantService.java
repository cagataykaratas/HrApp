package com.HRApp.service;

import com.HRApp.lib.dto.ApplicantDto;
import com.HRApp.entity.Applicant;
import com.HRApp.mapper.ApplicantMapper;
import com.HRApp.repository.ApplicantRepo;
import com.HRApp.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {

    private final ApplicantRepo applicantRepo;

    @Autowired
    private JobRepo jobRepo;

    public ApplicantService(ApplicantRepo applicantRepo) {
        this.applicantRepo = applicantRepo;
    }

    public ApplicantDto applyJob(Applicant applicant){
        ApplicantMapper applicantMapper = new ApplicantMapper();
        applicantRepo.save(applicant);
        return applicantMapper.toDto(applicant);
    }

    public List<ApplicantDto> getApplicants() {
        ApplicantMapper applicantMapper = new ApplicantMapper();
        List<Applicant> applicants = applicantRepo.findAll();
        List<ApplicantDto> allApplicants = new ArrayList<>();
        for(Applicant applicant : applicants){
            allApplicants.add(applicantMapper.toDto(applicant));
        }
        return allApplicants;
    }
}
