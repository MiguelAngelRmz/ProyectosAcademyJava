package com.springbatch.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importOrganizationJob;

    @GetMapping("/startJob")
    public ResponseEntity<String> startJob(@RequestParam String fileName) {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("fileName", fileName)
                    .toJobParameters();
            jobLauncher.run(importOrganizationJob, jobParameters);
            return ResponseEntity.ok("Job started successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Job failed to start: " + e.getMessage());
        }
    }
}
