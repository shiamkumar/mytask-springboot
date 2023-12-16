package com.tech.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tech.batch.entity.Employee;
import com.tech.batch.listener.EmployeeBatchJobCompletionListener;
import com.tech.batch.processor.EmployeeProcessor;
import com.tech.batch.reader.EmployeeReader;
import com.tech.batch.writer.EmployeeWriter;

@Configuration
public class EmployeeBatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	public EmployeeReader employeeReader;
	
	@Autowired
	public EmployeeWriter employeeWriter;
	
	@Bean
    public Job processJob() {
        return jobBuilderFactory.get("myEmployeeJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener())
            .flow(orderStep1())
            .end().build();
    }

	@Bean
    public Step orderStep1() {
        return stepBuilderFactory.get("myEmployeeStep")
        	.<Employee, Employee> chunk(3)
            .reader(employeeReader) 
            .processor(processor())
            .writer(employeeWriter)
            .build();
    }
    
    @Bean
	public ItemProcessor<Employee, Employee> processor() {
	    return new EmployeeProcessor();
	}

    @Bean
    public JobExecutionListener listener() {
        return new EmployeeBatchJobCompletionListener();
    }

}
