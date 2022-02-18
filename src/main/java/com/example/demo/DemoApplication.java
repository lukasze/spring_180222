package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
    Dodanie supermocy:
    - klasa konfig.
    - skanowanie @Component (@Controller, @Configuration, @Service etc.)
    - włączenie 'automagii' SpringBoot
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        // Kontekst Spring'a rozumany jako zbiór ziaren
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
    // Metody @Bean i klasy @Component dostarczają definicji ziaren
    @Bean(name = "myService2")
    MyService myService() {
        return new MyService();
    }

}
// Metody @Bean i klasy @Component dostarczają definicji ziaren
@Component
class MyService {

}