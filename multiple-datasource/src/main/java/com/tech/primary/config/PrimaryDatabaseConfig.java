package com.tech.primary.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = { "com.tech.primary.repo" })
public class PrimaryDatabaseConfig {

	@Value("${primary.spring.datasource.url}")
	private String url;

	@Value("${primary.spring.datasource.username}")
	private String username;

	@Value("${primary.spring.datasource.password}")
	private String password;

	@Primary
	@Bean
	public DataSource datasource() {
		return DataSourceBuilder.create().url(url).username(username).password(password).build();
	}

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			DataSource datasource) {
		return builder.dataSource(datasource).packages("com.tech.primary.entity").build();
	}

	@Primary
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory primaryEntityManagerFactory) {
		return new JpaTransactionManager(primaryEntityManagerFactory);
	}

}
