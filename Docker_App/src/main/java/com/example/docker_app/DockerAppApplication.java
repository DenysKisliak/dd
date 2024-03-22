package com.example.docker_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class DockerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerAppApplication.class, args);
    }

}
