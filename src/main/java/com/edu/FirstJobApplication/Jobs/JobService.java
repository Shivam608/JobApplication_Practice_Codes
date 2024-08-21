package com.edu.FirstJobApplication.Jobs;

import java.util.List;

public interface JobService {

    List<Job> findAllJobs();

    long createJob(Job job);

    Job getJobByID(long id);

    boolean deleteJobById(long id);

    boolean updateJobById(long id, Job updatedJob);
}
