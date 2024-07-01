package com.example.jobtest.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Job>> getAllJobs() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        return new ResponseEntity<>(jobService.createJob(job), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Job> getJobById(@RequestParam Long id) {
        return new ResponseEntity<>(jobService.getJobById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateJob(@RequestParam Long id ,@RequestBody Job job) {
        boolean res = jobService.updateJob(id, job);
        if (res)
            return new ResponseEntity<>("Job updated", HttpStatus.OK);
        else
            return new ResponseEntity<>("Job not found", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteJobById(@RequestParam Long id) {
        boolean res = jobService.deleteJobById(id);
        if(res)
            return new ResponseEntity<>("Job deleted", HttpStatus.OK);
        else
            return new ResponseEntity<>("Job not found", HttpStatus.BAD_REQUEST);
    }
}
