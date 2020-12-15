package com.example;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@SpringBootApplication
public class Application extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    	return builder.sources(Application.class);
    }

    @Bean
    public CommandLineRunner sampleData(EmployeeRepository repository) {
        return (args) -> {
            repository.save(new Employee("tester", "Testing"));
            repository.save(new Employee("developer", "Development"));
            repository.save(new Employee("splunkmaster", "Agile"));
        };
    }
}
