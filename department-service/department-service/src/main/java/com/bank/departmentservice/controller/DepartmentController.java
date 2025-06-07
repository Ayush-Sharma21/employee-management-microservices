package com.bank.departmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.departmentservice.dto.DepartmentDto;
import com.bank.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/bank/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hi user";
	}
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
		List<DepartmentDto> allDepartmentDto = departmentService.getAllDepartments();
		return new ResponseEntity<>(allDepartmentDto, HttpStatus.OK);
	}
	
	@GetMapping("/{department-code}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
		return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> deleteDepartmentById(@PathVariable Long id) {
//	    departmentService.deleteDepartmentById(id);
//	    return new ResponseEntity<>("Department deleted by ID", HttpStatus.OK);
//	}

	
	@DeleteMapping("/{department-code}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("department-code") String departmentCode) {
	    departmentService.deleteDepartmentByCode(departmentCode);
	    return new ResponseEntity<>("Department deleted successfully", HttpStatus.OK);
	}

}
