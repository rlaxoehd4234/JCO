package org.jco.communityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
public class JcoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JcoApplication.class, args);
    }

}
