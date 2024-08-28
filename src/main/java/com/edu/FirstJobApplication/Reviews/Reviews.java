package com.edu.FirstJobApplication.Reviews;

import com.edu.FirstJobApplication.Companies.Company;
import com.edu.FirstJobApplication.Jobs.Job;
import jakarta.persistence.*;

@Entity
@Table(name = "Reviews_Table")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;
    private enum reviewType {
        positive,
        negative,
        neutral,
    }
    private String reviewDescription;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Job job;

    public Reviews() {
    }

    public Reviews(long reviewId, String reviewDescription, Company company, Job job) {
        this.reviewId = reviewId;
        this.reviewDescription = reviewDescription;
        this.company = company;
        this.job = job;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
