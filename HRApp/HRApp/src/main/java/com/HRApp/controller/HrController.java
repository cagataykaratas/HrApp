package com.HRApp.controller;

import com.HRApp.lib.dto.ApplicantDto;
import com.HRApp.lib.dto.HrDto;
import com.HRApp.lib.dto.JobDto;
import com.HRApp.mapper.HrMapper;
import com.HRApp.mapper.JobMapper;
import com.HRApp.repository.HrRepo;
import com.HRApp.service.ApplicantService;
import com.HRApp.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/hr")
public class HrController {

    private final HrService hrService;
    private final HrRepo hrRepo;

    @Autowired
    private ApplicantService applicantService;

    public HrController(HrService hrService, HrRepo hrRepo) {
        this.hrService = hrService;
        this.hrRepo = hrRepo;
    }

    @PostMapping("/create-hr")
    public HrDto signUpHr(@RequestBody HrDto hrDto){
        HrMapper hrMapper = new HrMapper();
        return hrService.save(hrMapper.toEntity(hrDto));
    }

    @PostMapping("/add-job")
    public JobDto addJob(@RequestBody JobDto jobDto){
        JobMapper jobMapper = new JobMapper();
        jobDto.setHr(hrRepo.findByEmail(jobDto.getHrEmail()));
        return hrService.addJob(jobMapper.toEntity(jobDto));
    }

}
