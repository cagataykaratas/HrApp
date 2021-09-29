package com.HRApp.service;

import com.HRApp.details.JobDetails;
import com.HRApp.entity.Job;
import com.HRApp.lib.resource.JobResource;
import com.HRApp.mapper.JobMapper;
import com.HRApp.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public List<JobResource> getJobs() {
        JobMapper jobMapper = new JobMapper();
        List<Job> jobs = jobRepo.findAll();
        List<JobResource> allJob = new ArrayList<>();
        for (Job job : jobs) {
            if(job.getIsActive())
                allJob.add(jobMapper.toResource(job));
        }
        return allJob;
    }
    public JobResource getJob(String jobTitle){
        JobMapper jobMapper = new JobMapper();
        if ((jobRepo.findByTitle(jobTitle).size()) > 1)
            throw new RuntimeException("job title must be unique ");
        return jobMapper.toResource((jobRepo.findByTitle(jobTitle).get(0)));
    }

}
