package com.HRApp.lib.dto;

import com.HRApp.entity.Applicant;
import com.HRApp.entity.Hr;
import com.HRApp.repository.HrRepo;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class JobDto {


    private String hrEmail;
    private String title;
    private String description;
    private int numberOfPeople;
    private Date applicationDate;
    private Hr hr;

}
