package com.ioc.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ioc.app.entities.Employee;

@SpringBootApplication
public class SpringBootHibernateProjectApplication implements CommandLineRunner{

	@Autowired
	private EmployeeDao employeeDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee= getEmployee();
		employeeDao.createEmployee(employee);
	}

	private Employee getEmployee() {
		Employee employee = new Employee();
		employee.setName("Neeraj");
		employee.setDoj(new Date());
		employee.setSalary(80000.0);
		return employee;
	}

}
