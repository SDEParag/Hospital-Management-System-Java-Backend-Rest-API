package com.hospital_management_system;

import com.hospital_management_system.entity.Role;
import com.hospital_management_system.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class HospitalManagementSystemApplication implements CommandLineRunner {


	@Autowired
	private RoleRepository roleRepository;


	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


	public static void main(String[] args){


		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Role adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		roleRepository.save(adminRole);


		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		roleRepository.save(userRole);


	}
}

