gitpackage com.tudu.todoapp;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Main {

    public static void main(String[] args) {
        BasicConfigurator.configure(); // logging
        SpringApplication.run(Main.class, args);
    }
}
