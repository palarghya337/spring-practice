package in.spring.practice.batch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class RunSpringBatch {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "in.spring.practice.batch");

        Job job = context.getBean(Job.class);
        Map<String, JobParameter> listOfJobParameter = new HashMap<>();
        listOfJobParameter.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters();
        JobLauncher launcher = context.getBean(JobLauncher.class);
        try {
            JobExecution execution = launcher.run(job, jobParameters);
            System.out.println(execution.getStatus());
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }
}
