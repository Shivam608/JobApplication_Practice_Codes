package com.edu.FirstJobApplication.Jobs;

/**
 * GET   ----    /Job_Application/getJobList             ---> Get All Jobs
 * GET   ----    /Job_Application/getJobList/{id}        ---> Get Job by ID
 * POST  ----    /Job_Application/addJobs                ---> Add a New Job (Request Body Should Contain the Job Details)
 * Delete----    /Job_Application/deleteJob/{id}         ---> Delete a Job by ID
 * PUT   ----    /Job_Application/updateJob/{id}         ---> Update Details of Existing Job by ID (Req Body should have Same format with Updated Job Details)
 */

// Spring Imports
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Utility Package Imports
import java.util.List;

@RestController
@RequestMapping("/Job_Application")
public class jobController {
    private jobService jobService;

    public jobController(jobService jobService) {
        this.jobService = jobService;
    }

    // Get The List with All Available Jobs
    @GetMapping("/getJobList")
    public ResponseEntity<List<Job>> findAllJobs() {
        return ResponseEntity.ok(jobService.findAllJobs());
    }

    // Add a Job in Repo
    @PostMapping("/addJobs")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job Created Successfully with JobID: " + job.getJobId(), HttpStatus.CREATED);
    }

    // Get Job details by Job ID
    @GetMapping("/getJobList/{id}")
    public ResponseEntity<Job> getJobByID(@PathVariable long id) {
        Job job = jobService.getJobByID(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a Specific Job by ID
    @DeleteMapping("/deleteJob/{id}")
    public ResponseEntity<String> deleteJobByID(@PathVariable long id) {
        boolean deleted = jobService.deleteJobById(id);
        if (deleted) {
            return new ResponseEntity<>("Job with Specified Id: " + id + " is Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job ID Not Found", HttpStatus.NOT_FOUND);
    }

    // Update a Specific Job by Id
    @PutMapping("/updateJob/{id}")
    public ResponseEntity<String> updateJob(@PathVariable long id, @RequestBody Job updatedJob) {
        boolean updated = jobService.updateJobById(id, updatedJob);
        if (updated) {
            return new ResponseEntity<>("Job Updated for ID:" + id, HttpStatus.OK);
        }
        return new ResponseEntity<>("No Jobs found With ID:" + id, HttpStatus.NOT_FOUND);
    }


}

/*
 * GET   ----    /Job_Application/getJobList             ---> Get All Jobs
 * GET   ----    /Job_Application/getJobList/{id}        ---> Get Job by ID
 * POST  ----    /Job_Application/addJobs                ---> Add a New Job (Request Body Should Contain the Job Details)
 * Delete----    /Job_Application/deleteJob/{id}         ---> Delete a Job by ID
 * PUT   ----    /Job_Application/updateJob/{id}         ---> Update Details of Existing Job by ID (Req Body should have Same format with Updated Job Details)
 *
 */
