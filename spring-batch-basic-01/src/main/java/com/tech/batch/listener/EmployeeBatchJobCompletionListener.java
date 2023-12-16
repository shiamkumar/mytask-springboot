package com.tech.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class EmployeeBatchJobCompletionListener extends JobExecutionListenerSupport {
	
	Logger logger = LoggerFactory.getLogger(EmployeeBatchJobCompletionListener.class);

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.info("BATCH JOB COMPLETED SUCCESSFULLY");
        }
    }
}
