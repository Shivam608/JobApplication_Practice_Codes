package com.edu.FirstJobApplication.Reviews;

import com.edu.FirstJobApplication.Companies.Company;
import com.edu.FirstJobApplication.Jobs.Job;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Reviews_Table")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;

    private String reviewTitle;

    private enum reviewType {
        positive,
        negative,
        neutral,
    }
    private String reviewDescription;

    private double rating;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;

//    @JsonIgnore
//    @ManyToOne
//    private Job job;

    public Reviews() {
    }

    public Reviews(long reviewId, String reviewTitle, String reviewDescription, double rating, Company company/*, Job job*/) {
        this.reviewId = reviewId;
        this.reviewTitle = reviewTitle;
        this.reviewDescription = reviewDescription;
        this.rating = rating;
        this.company = company;
//        this.job = job;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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

//    public Job getJob() {
//        return job;
//    }
//
//    public void setJob(Job job) {
//        this.job = job;
//    }
}
