package in.spring.practice.main;

import in.spring.practice.configuration.TempConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                TempConfiguration.class);
        System.out.println("context-object-created");
        context.close();
        System.out.println("context-closed");
    }
}
