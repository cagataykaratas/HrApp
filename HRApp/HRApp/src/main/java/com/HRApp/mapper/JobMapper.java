package com.HRApp.mapper;

import com.HRApp.details.JobDetails;
import com.HRApp.lib.dto.JobDto;
import com.HRApp.entity.Job;
import com.HRApp.lib.resource.JobResource;

import java.util.Optional;


public class JobMapper {


    public JobDto toDto(Job job){
        JobDto jobDto = new JobDto();
        jobDto.setDescription(job.getDescription());
        jobDto.setApplicationDate(job.getApplicationDate());
        jobDto.setTitle(job.getTitle());
        jobDto.setNumberOfPeople(job.getNumberOfPeople());
        return jobDto;
    }

    public Job toEntity(JobDto jobDto){
        Job job = new Job();
        job.setDescription(jobDto.getDescription());
        job.setTitle(jobDto.getTitle());
        job.setApplicationDate(jobDto.getApplicationDate());
        job.setNumberOfPeople(jobDto.getNumberOfPeople());
        job.setHr(jobDto.getHr());
        return job;
    }

    public JobResource toResource(Job job){
        if (job == null) {
            return null;
        }
        JobResource jobResource = new JobResource();
        jobResource.setJobTitle(job.getTitle());
        jobResource.setNumberOfPeople(job.getNumberOfPeople());
        jobResource.setJobDescription(job.getDescription());
        jobResource.setApplicationDate(job.getApplicationDate());
        return jobResource;
    }
}
