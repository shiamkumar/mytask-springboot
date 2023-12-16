package com.tech.batch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.tech.batch.entity.Employee;
import com.tech.batch.mapper.EmployeeFieldSetMapper;

@Component
public class EmployeeReader extends FlatFileItemReader<Employee> implements ItemReader<Employee> {
	
	public EmployeeReader() {
		initialize();
	}
	
	public void initialize() {
		setResource(new ClassPathResource("/csv/employees.csv"));
		setLinesToSkip(1);
		setLineMapper(getDefaultLineMapper());
	}
	
	public DefaultLineMapper<Employee> getDefaultLineMapper() {
		DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] { "id", "firstName", "lastName", "email" });
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(new EmployeeFieldSetMapper());
		lineMapper.afterPropertiesSet();
		return lineMapper;
	}

}
