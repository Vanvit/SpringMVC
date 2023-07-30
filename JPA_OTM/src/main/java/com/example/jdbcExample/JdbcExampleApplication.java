package com.example.jdbcExample;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbcExample.entity.CompanyEntity;
import com.example.jdbcExample.entity.EmployeeEntity;
import com.example.jdbcExample.repository.CompanyRepository;
import com.example.jdbcExample.repository.EmployeeRepository;


@SpringBootApplication
@RestController
public class JdbcExampleApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JdbcExampleApplication.class, args);
	}
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		//Company - employee 1 - n

		EmployeeEntity employee1 = new EmployeeEntity();
		employee1.setName("Minh");
		employeeRepository.save(employee1);
		
		EmployeeEntity employee2 = new EmployeeEntity();
		employee1.setName("Hoa");
		employeeRepository.save(employee2);
		
		EmployeeEntity employee3 = new EmployeeEntity();
		employee1.setName("Trang");
		employeeRepository.save(employee3);
		
		CompanyEntity company1 = new CompanyEntity();
		company1.setName("FPT");
		companyRepository.save(company1);
		
/*		employee1.setCompany(company1);
//		employeeRepository.save(employee1); // dung Transaction tu luu xuong database
		company1.getEmployees().add(employee1);*/
		
		company1.addEmployee(employee1);
		company1.addEmployee(employee2);
		company1.addEmployee(employee3);
		
		
		System.out.println(employee1.getCompany().getName());
		System.out.println(company1.getEmployees());
		
/*		
		// Delete
//		employeeRepository.deleteAll();
		employeeRepository.deleteAllByCompanyId(company1.getCompanyId());
		companyRepository.delete(company1);
*/
	}
	//http://localhost:8080/
	@GetMapping
	public void test() {
		Optional<EmployeeEntity> employee = employeeRepository.findById(1L);
		employee.get().getName();
		System.out.println(employee.get().getCompany().getName());
	}

}
