package com.tech.secondary.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "secondaryEntityManagerFactory", 
		transactionManagerRef = "secondaryTransactionManager", 
		basePackages = {"com.tech.secondary.repo" }
		)
public class SecondaryDatabaseConfig {

	@Value("${secondary.spring.datasource.url}")
	private String url;

	@Value("${secondary.spring.datasource.username}")
	private String username;

	@Value("${secondary.spring.datasource.password}")
	private String password;

	@Bean(name = "secondaryDataSource")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().url(url).username(username).password(password).build();
	}

	@Bean(name = "secondaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
			EntityManagerFactoryBuilder builder,
			@Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
		return builder.dataSource(secondaryDataSource).packages("com.tech.secondary.entity").build();
	}

	@Bean(name = "secondaryTransactionManager")
	public PlatformTransactionManager secondaryTransactionManager(
			@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory secondaryEntityManagerFactory) {
		return new JpaTransactionManager(secondaryEntityManagerFactory);
	}
}
