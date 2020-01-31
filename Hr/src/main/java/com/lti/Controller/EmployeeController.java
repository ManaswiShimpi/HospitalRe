package com.lti.Controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Employee;
import com.lti.service.EmployeeService;

@RestController
@RequestMapping("/hr")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	//@RequestMapping("/create")
	@PostMapping("/create")
	 @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	public String create(@RequestParam("empid") String empid, @RequestParam("name") String name,
			@RequestParam("department") String department,
			@RequestParam(value = "salary", required = true) float salary) {
		Employee p = employeeService.create(empid, name, department, salary);
		return p.toString();
	}
	 @Produces ({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	@GetMapping("/get")
	public Employee getEmployee(@RequestParam("empid") String empid) {
		return employeeService.getByEmpid(empid);
	}
	 @Produces ({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}
	 @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	@PutMapping("/update")
	public String update(@RequestParam String empid, @RequestParam String name, @RequestParam String department,
			@RequestParam float salary) {
		Employee p = employeeService.update(empid, name, department, salary);
		return p.toString();
	}
	 @Produces ({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	@DeleteMapping("/delete")
	public String delete(@RequestParam String empid) {
		employeeService.delete(empid);
		return "Deleted" + empid;
	}
	 @Produces ({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})	
	 @DeleteMapping("/deleteAll")
	public String deleteAll() {
		employeeService.deleteAll();
		return "Deleted all records";
	}

}
