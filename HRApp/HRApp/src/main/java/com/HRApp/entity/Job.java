package com.HRApp.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="job")
public class Job implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2",strategy ="uuid2")
    @Type(type = "uuid-char")
    private UUID id;

    @NotNull
    @Column(name = "title", unique = true)
    private String title;

    private String description;

    @Column(name = "hire_number")
    private int numberOfPeople;

    @Column(name = "last_date")
    private Date applicationDate;

    @NotNull
    @Column(name = "is_active")
    private Boolean isActive = true;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hr_id", referencedColumnName = "id",nullable = false)
    @ToString.Exclude
    private Hr hr;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "job_applicants",
            joinColumns = @JoinColumn(name = "job_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "applicant_id", referencedColumnName = "id"))
    @ToString.Exclude
    private List<Applicant> applicants = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Job job = (Job) o;

        return Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return 615373742;
    }
}
