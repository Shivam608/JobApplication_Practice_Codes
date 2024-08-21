package com.edu.FirstJobApplication.Jobs.impl;

import com.edu.FirstJobApplication.Jobs.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobServiceImpl implements JobService {

    // List of Jobs to be stored
//    private List<Job> jobList = new ArrayList<>();

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //Implementing H2 Repository
    JobRepository jobRepository;

    // Hashset = Accepts only Unique Values, No duplicates
    private Set<Long> usedIDs = new HashSet<>();
    Random randomNumber = new Random();

    // get All Jobs
    @Override
    public List<Job> findAllJobs() {
        System.out.println("Jobs LIST has been Populated Successfully ");
//        return jobList();
        return jobRepository.findAll();
    }

    // Add a Job to list
    @Override
    public long createJob(Job job) {
        long uniqueID;
        // This loop performs a check for UniqueId is not to be duplicated
        do {
            //Generate Unique ID
            uniqueID = Long.parseLong(String.format("%04d", randomNumber.nextLong(10000)));
        }  // Check if the hashSet contains the UniqueId generated
        while (usedIDs.contains(uniqueID));

        // Add Uniques ID to HashSet
        usedIDs.add(uniqueID);

        job.setJobId(uniqueID);
//        jobList.add(job);
        jobRepository.save(job);
        System.out.println("Job Created Successfully with Uniques ID:" + uniqueID);
        return uniqueID;
    }

    @Override
    public Job getJobByID(long id) {
//        for (Job job : jobList) {
//            if (job.getJobId() == id) {
//                System.out.println("Job found with ID: " + id);
//                return job;
//            }
//        }
//        System.out.println("No job found with ID: " + id);
//        return null;

        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(long id) {
//        Iterator<Job> iterator = jobList.iterator();
//        while (iterator.hasNext()) {
//            Job job = iterator.next();
//            if (job.getJobId() == id) {
//                iterator.remove();
//                System.out.println("The Job searched with ID: " + id + " matched an ID: " + job.getJobId() +
//                        " available in the list and is Removed from jobList");
//                return true;
//            }
//        }
//        System.out.println("No Jobs Found with ID:" + id);
//        return false;
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Unable to find Job with Specified ID." + e);
            return false;
        }


    }

    @Override
    public boolean updateJobById(long id, Job updatedJob) {
//        for (Job job : jobList) {
//            if (job.getJobId() == id) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

}
