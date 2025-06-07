package com.bank.departmentservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.departmentservice.dto.DepartmentDto;
import com.bank.departmentservice.entity.Department;
import com.bank.departmentservice.repository.DepartmentRepository;
import com.bank.departmentservice.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

		Department department = new Department(departmentDto.getId(), departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode());

		Department savedDepartment = departmentRepository.save(department);

		DepartmentDto savedDeparmentDto = new DepartmentDto(savedDepartment.getId(),
				savedDepartment.getDepartmentName(), savedDepartment.getDepartmentDescription(),
				savedDepartment.getDepartmentCode());

		return savedDeparmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String code) {

		Department department = departmentRepository.findByDepartmentCode(code);

		DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getDepartmentName(),
				department.getDepartmentDescription(), department.getDepartmentCode());
		return departmentDto;
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		List<Department> departments = departmentRepository.findAll();

		List<DepartmentDto> departmentDto = departments.stream()
				.map(department -> new DepartmentDto(department.getId(), department.getDepartmentName(),
						department.getDepartmentDescription(), department.getDepartmentCode()))
				.collect(Collectors.toList());
		return departmentDto;
	}

	@Override
	public void deleteDepartmentById(Long id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public void deleteDepartmentByCode(String departmentCode) {
		Department department = departmentRepository.findByDepartmentCode(departmentCode);
		if (department != null) {
			departmentRepository.delete(department);
		} else {
			throw new RuntimeException("Department not found");
		}
	}

}
