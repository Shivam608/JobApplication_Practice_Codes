package com.edu.FirstJobApplication.Jobs;

import com.edu.FirstJobApplication.Companies.Company;
//import com.edu.FirstJobApplication.Reviews.Reviews;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "job_table")
public class Job {

    @ManyToOne
    private Company company;

//    @JsonIgnore
//    @OneToMany(mappedBy = "job")
//    private List<Reviews> reviews;

    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long jobId;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    public Job() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Job(long jobId, String title, String description, String minSalary, String maxSalary, String location) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;

    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
