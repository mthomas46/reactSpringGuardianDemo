package com.example.reactSpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final GuardianRepository repository;

    @Autowired
    public DatabaseLoader(GuardianRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.save(new Guardian("Afroking42", "4611686018471247673"));
        System.out.println("test");
    }
}
