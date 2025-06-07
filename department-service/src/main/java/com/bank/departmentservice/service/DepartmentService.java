package com.bank.departmentservice.service;

import java.util.List;

import com.bank.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto departmentDto);

	DepartmentDto getDepartmentByCode(String code);

	List<DepartmentDto> getAllDepartments();

	void deleteDepartmentByCode(String departmentCode);

	void deleteDepartmentById(Long id);

}
