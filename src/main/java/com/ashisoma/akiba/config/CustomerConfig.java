package com.ashisoma.akiba.config;

import com.ashisoma.akiba.entity.Customer;
import com.ashisoma.akiba.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner runner(CustomerRepository repository){
        return args -> {
            Customer Flo = new Customer(112345,454366,"Flo","Muange","Kapsabet","mokito");
            Customer Melo = new Customer(242212,245234,"Melo","Okoth","Egerton","keepLeft");

            repository.saveAll(
                    List.of(Flo, Melo)
            );
        };

    }
}
