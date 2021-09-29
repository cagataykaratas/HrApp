package com.HRApp.mapper;

import com.HRApp.lib.dto.ApplicantDto;
import com.HRApp.entity.Applicant;

public class ApplicantMapper {
    public ApplicantDto toDto(Applicant applicant){
        ApplicantDto applicantDto = new ApplicantDto();
        applicantDto.setAddress(applicant.getAddress());
        applicantDto.setComment(applicant.getComment());
        applicantDto.setEmail(applicant.getEmail());
        applicantDto.setName(applicant.getName());
        applicantDto.setPhoneNumber(applicant.getPhoneNumber());
        return applicantDto;
    }

    public Applicant toEntity(ApplicantDto applicantDto){
        Applicant applicant = new Applicant();
        applicant.setPhoneNumber(applicantDto.getPhoneNumber());
        applicant.setComment(applicantDto.getComment());
        applicant.setName(applicantDto.getName());
        applicant.setEmail(applicantDto.getEmail());
        applicant.setAddress(applicantDto.getAddress());
        applicant.setJobs(applicantDto.getJobs());
        return applicant;
    }
}
