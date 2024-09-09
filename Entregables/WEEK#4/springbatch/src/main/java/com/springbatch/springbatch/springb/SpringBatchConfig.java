package com.springbatch.springbatch.springb;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.springbatch.springbatch.entity.Organization;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Organization> reader(@Value("#{jobParameters['fileName']}") String fileName) {
        return new FlatFileItemReaderBuilder<Organization>()
                .name("organizationReader")
                .resource(new ClassPathResource(fileName))
                .delimited()
                .delimiter(DelimitedLineTokenizer.DELIMITER_COMMA)
                .names("id", "name", "country", "employees")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Organization.class);
                }})
                .build();
    }

    @Bean
    public ItemProcessor<Organization, Organization> processor() {
        return new Processor();
    }

    @Bean
    public Job importOrganizationJob(JobRepository jobRepository, PlatformTransactionManager transactionManager, EntityManagerFactory entityManagerFactory) {
        Step step1 = new StepBuilder("step1", jobRepository)
                .<Organization, Organization>chunk(10, transactionManager)
                .reader(reader(null))
                .processor(processor())
                .writer(new JpaItemWriterBuilder<Organization>()
                        .entityManagerFactory(entityManagerFactory)
                        .build())
                .build();

        return new JobBuilder("importOrganizationJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .build();
    }
}
