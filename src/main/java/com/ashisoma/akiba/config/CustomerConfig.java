package com.ashisoma.akiba.config;

import com.ashisoma.akiba.entity.Customer;
import com.ashisoma.akiba.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner runner(CustomerRepository repository){
        return args -> {

        };
    }
}
