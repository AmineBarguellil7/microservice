package com.example.microservice;

import com.example.microservice.entity.Candidat;
import com.example.microservice.repos.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}

	@Autowired
	private CandidatRepository candidatRepository;

	@Bean
	ApplicationRunner init() {
		return (args) -> {
			candidatRepository.save(new Candidat(1,"amine","Barg","amine@esprit.tn"));
			candidatRepository.save(new Candidat(2,"chacker","Elj","chacker@esprit.tn"));
			candidatRepository.findAll().forEach(System.out::println);
		};
	}

}
