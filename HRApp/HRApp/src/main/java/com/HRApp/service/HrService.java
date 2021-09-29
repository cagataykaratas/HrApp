package com.HRApp.service;

import com.HRApp.lib.dto.HrDto;
import com.HRApp.lib.dto.JobDto;
import com.HRApp.entity.Hr;
import com.HRApp.entity.Job;
import com.HRApp.mapper.HrMapper;
import com.HRApp.mapper.JobMapper;
import com.HRApp.repository.HrRepo;
import com.HRApp.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HrService {

    @Autowired
    private HrRepo hrRepo;
    @Autowired
    private JobRepo jobRepo;

    Hr hr1 = new Hr();

    public HrDto save(Hr hr){
        HrMapper hrMapper = new HrMapper();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        hr.setPassword(encoder.encode(hr.getPassword()));
        hrRepo.save(hr);
        return hrMapper.toDto(hr);

    }

    public JobDto addJob(Job job){
        JobMapper jobMapper = new JobMapper();
        jobRepo.save(job);
        return jobMapper.toDto(job);
    }

}
