package com.tech.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/batch")
public class EmployeeController {
	
	@Autowired
    JobLauncher launcher;

    @Autowired
    Job myEmployeeJob;

    @GetMapping("/start")
    public String startBatch() throws Exception {
    	JobParameters jobParameters = new JobParametersBuilder()
    			.addString("JobID", String.valueOf(System.currentTimeMillis())).toJobParameters();
    	launcher.run(myEmployeeJob, jobParameters);
        return "Batch job has been invoked";
    }
    
}


