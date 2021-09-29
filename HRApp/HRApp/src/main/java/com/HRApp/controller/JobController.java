package com.HRApp.controller;

import com.HRApp.details.JobDetails;
import com.HRApp.entity.Job;
import com.HRApp.lib.resource.JobResource;
import com.HRApp.mapper.JobMapper;
import com.HRApp.repository.ApplicantRepo;
import com.HRApp.repository.JobRepo;
import com.HRApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/job")
public class JobController {


    @Autowired
    private JobService jobService;

    @Autowired
    private JobRepo jobRepo;

    @GetMapping("/job-list")
    public List<JobResource> getAllJobs() {
        return jobService.getJobs();
    }

    /* Delete job by ID */
    @DeleteMapping("/delete-job/{id}")
    public Map<String, Boolean> deleteUser(
            @PathVariable(value = "id") UUID id) {
        Job job = jobRepo.findById(id);

        jobRepo.delete(job);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/get-job")
    public JobResource getJob(@RequestParam("jobTitle") String jobTitle) {
        return jobService.getJob(jobTitle);
    }
}
