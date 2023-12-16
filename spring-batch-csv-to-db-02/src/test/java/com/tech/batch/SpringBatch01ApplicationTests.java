package com.tech.batch;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBatchTest
@SpringBootTest
@RunWith(SpringRunner.class)
class SpringBatch01ApplicationTests {

	@Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;
	
    @Autowired
    private JobRepositoryTestUtils jobRepositoryTestUtils;
    
    @BeforeClass
    public static void beforeClass() {
        // set some env variables to allow Spring Context to load up !
    }
    
    @After
    public void cleanUp() {
        jobRepositoryTestUtils.removeJobExecutions();
    }
    
    @Test
    public void launchJob() throws Exception {
    	JobExecution jobExecution = this.jobLauncherTestUtils.launchJob();    
        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
        
        StepExecution stepExecution = jobExecution.getStepExecutions().iterator().next();
        assertEquals(BatchStatus.COMPLETED, stepExecution.getStatus());
    }
    
}

