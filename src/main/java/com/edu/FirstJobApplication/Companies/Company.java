package com.edu.FirstJobApplication.Companies;

import com.edu.FirstJobApplication.Jobs.Job;
import com.edu.FirstJobApplication.Reviews.Reviews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="CompanyTable")
public class Company {

    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    private long companyId;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobList;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
     private List<Reviews> reviews;

    // Default Constructor for JPA
    public Company() {
    }

    public Company(long companyId, String name, String description, List<Job> jobList) {
        this.companyId = companyId;
        this.name = name;
        this.description = description;
        this.jobList = jobList;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }
}
