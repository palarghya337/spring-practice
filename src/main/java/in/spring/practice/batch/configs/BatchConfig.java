package in.spring.practice.batch.configs;

import in.spring.practice.batch.model.User;
import in.spring.practice.batch.processors.UserProcessor;
import in.spring.practice.batch.writers.UserWriters;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public Job createJob(JobBuilderFactory jobBuilderFactory, Step step) {

        return jobBuilderFactory.get("LOAD-USER")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    public Step createStep(
            StepBuilderFactory stepBuilderFactory, Resource resource, UserProcessor userProcessor,
            UserWriters userWriters) {

        return stepBuilderFactory.get("LOAD-USER-STEP")
                .chunk(10)
                .reader(getUserReader(resource))
                .processor(userProcessor)
                .writer(userWriters)
                .build();
    }

    private ItemReader<User> getUserReader(@Value("${user.file.name}") Resource resource) {
        FlatFileItemReader<User> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(resource);
        itemReader.setName("CSV-Reader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(getUserLineMapper());
        return itemReader;
    }

    private LineMapper<User> getUserLineMapper() {

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setNames("id", "name", "userType", "dateOfBirth");

        BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(User.class);

        DefaultLineMapper<User> userDefaultLineMapper = new DefaultLineMapper<>();
        userDefaultLineMapper.setLineTokenizer(lineTokenizer);
        userDefaultLineMapper.setFieldSetMapper(fieldSetMapper);
        return userDefaultLineMapper;
    }
}
