package net.eren.departmentservice.service;

import net.eren.departmentservice.dto.DepartmentDto;
import net.eren.departmentservice.entitiy.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(DepartmentDto departmentDto);
    Department findDepartmentById(Long departmentId);
    Department getDepartmentByCode(String departmentCode);
    List<Department> findAllDepartments();
    void deleteDepartmentById(Long departmentId);

}
