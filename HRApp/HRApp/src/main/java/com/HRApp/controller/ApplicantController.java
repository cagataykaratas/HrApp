package com.HRApp.controller;

import com.HRApp.lib.dto.ApplicantDto;
import com.HRApp.mapper.ApplicantMapper;
import com.HRApp.repository.JobRepo;
import com.HRApp.service.ApplicantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/applicant")
public class ApplicantController {


    private final ApplicantService applicantService;
    private final JobRepo jobRepo;

    public ApplicantController(ApplicantService applicantService, JobRepo jobRepo) {
        this.applicantService = applicantService;
        this.jobRepo = jobRepo;
    }
    @PostMapping("/apply-to-job")
    public ApplicantDto applyJob(@RequestBody ApplicantDto applicantDto){
        ApplicantMapper applicantMapper = new ApplicantMapper();
        applicantDto.setJobs(jobRepo.findByTitle(applicantDto.getTitle()));
        return applicantService.applyJob(applicantMapper.toEntity(applicantDto));
    }
    @GetMapping("/get-applicants")
    public List<ApplicantDto> getApplicants(){
        return applicantService.getApplicants();
    }
}
