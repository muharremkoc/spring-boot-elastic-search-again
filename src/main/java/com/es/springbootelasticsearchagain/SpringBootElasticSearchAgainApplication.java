package com.es.springbootelasticsearchagain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class SpringBootElasticSearchAgainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootElasticSearchAgainApplication.class, args);
    }

}
