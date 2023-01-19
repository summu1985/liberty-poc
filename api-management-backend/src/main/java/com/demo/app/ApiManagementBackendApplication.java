package com.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.app.model.Employee;
import com.demo.app.model.EmployeeRepository;

@SpringBootApplication
public class ApiManagementBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiManagementBackendApplication.class, args);
	}
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception{
		this.employeeRepository.save(new Employee(1, "Neha", "Neha@redhat.com"));
		this.employeeRepository.save(new Employee(2, "Sumit", "Sumit@redhat.com"));
		this.employeeRepository.save(new Employee(3, "Anuva", "Anuva@redhat.com"));
		this.employeeRepository.save(new Employee(4, "Dheeraj", "Dheeraj@redhat.com"));
		this.employeeRepository.save(new Employee(5, "Prasad", "Prasad@redhat.com"));
		this.employeeRepository.save(new Employee(6, "Siddhant", "Siddhant@redhat.com"));
		this.employeeRepository.save(new Employee(7, "Gopal", "Gopal@redhat.com"));
	}

}
