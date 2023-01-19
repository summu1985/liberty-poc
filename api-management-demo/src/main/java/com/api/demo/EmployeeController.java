package com.api.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
		
	@RequestMapping("/employees")
	public List<Employee> retrieveAllEmployees(){
		return Arrays.asList(
				new Employee(1, "Neha","neha@redhat.com"),
				new Employee(2, "Abhishek","abhishek@redhat.com")
				);
	}
}

