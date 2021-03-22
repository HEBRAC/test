package com.cjava.apirest01.controller;
/*
 * Aplicativo desarrollado para la clase de Java Expert
 * Autor: CJavaPeru/Edwin Maravi (emaravi@gmail.com)
 * Version 0.001
 * www.cjavaperu.com
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.*;

import com.cjava.apirest01.model.Employee;

@RestController
public class EmployeeController
{
	@GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
	public String getHealthCheck()
	{
		return "{ \"todoOk\" : true }";
	}

	@GetMapping("/students")
	public List<Employee> getEmployees()
	{
		List<Employee> employeesList = new ArrayList<Employee>();
		employeesList.add(new Employee("1","Brayann","Hernández","brayannhernandez@gmail.com"));
		//employeesList.add(new Employee("2","noritza","rondon","info@cjavaperu.com"));
		return employeesList;
	}
	
	@GetMapping("/student/{id}")
	public Employee getEmployee(@PathVariable String id)
	{
		Employee emp = new Employee(id, "Brayann","Hernández","brayannhernandez@gmail.com");
		return emp;
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable String id)
	{
		Employee emp = newEmployee;
		return emp;
	}
	
	@DeleteMapping(value = "/employee/{id}", produces = "application/json; charset=utf-8")
	public String deleteEmployee(@PathVariable String id) {
		return "{ \"operacionExitosa\" : true }";
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee newEmployee)
	{
		String id = String.valueOf(new Random().nextInt());
		Employee emp = new Employee(id, newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getEmail());
		return emp;
	}
}
