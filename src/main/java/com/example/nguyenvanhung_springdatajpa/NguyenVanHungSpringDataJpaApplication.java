package com.example.nguyenvanhung_springdatajpa;

import com.example.nguyenvanhung_springdatajpa.Entity.Student;
import com.example.nguyenvanhung_springdatajpa.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NguyenVanHungSpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NguyenVanHungSpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(StudentRepository repository){
        return (args -> {
            insertStudent(repository);
            System.out.println(repository.findAll());
        });
    }

    private void insertStudent(StudentRepository repository){
        Student student =  Student.builder()
                .firstName("Van")
                .lastName("Hung")
                .email("hung@gmail.com")
                .build();
        repository.save(student);
    }


}
