package com.HRApp.details;

import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class JobDetails {

    private String title;
    private String description;
    private Date applicationDate;
    private int numberOfPeople;
}
