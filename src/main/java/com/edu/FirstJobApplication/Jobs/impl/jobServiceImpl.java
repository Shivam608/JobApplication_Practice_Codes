package com.edu.FirstJobApplication.Jobs.impl;

import com.edu.FirstJobApplication.Jobs.Job;
import com.edu.FirstJobApplication.Jobs.jobService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class jobServiceImpl implements jobService {

    // List of Jobs to be stored
    private List<Job> jobList = new ArrayList<>();

    // Hashset = Accepts only Unique Values, No duplicates
    private Set<Long> usedIDs = new HashSet<>();
    Random randomNumber = new Random();

    // get All Jobs
    @Override
    public List<Job> findAllJobs() {
        return jobList;
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
        jobList.add(job);
        return uniqueID;
    }

    @Override
    public Job getJobByID(long id) {
        for (Job job : jobList) {
            if (job.getJobId() == id) {
                System.out.println("Job found with ID: " + id);
                return job;
            }
        }
        System.out.println("No job found with ID: " + id);
        return null;
    }

    @Override
    public boolean deleteJobById(long id) {
        Iterator<Job> iterator = jobList.iterator();
        while (iterator.hasNext()) {
            Job job = iterator.next();
            if (job.getJobId() == id) {
                iterator.remove();
                System.out.println("The Job searched with ID: " + id + "Matched an ID: " + job.getJobId() +
                        " available in the list and is Removed from jobList");
                return true;
            }
        }
        System.out.println("No Jobs Found with ID:" + id);
        return false;
    }

    @Override
    public boolean updateJobById(long id, Job updatedJob) {
        for (Job job : jobList) {
            if (job.getJobId() == id) {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }

}
