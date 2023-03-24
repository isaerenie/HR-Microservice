package net.eren.employeeservice.service;


import net.eren.employeeservice.dto.APIResponseDto;
import net.eren.employeeservice.dto.EmployeeDto;
import net.eren.employeeservice.entitiy.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
    Employee getEmployeeByCode(String employeeCode);
    List<Employee> findAllEmployees();
    void deleteEmployeeById(Long employeeId);
    Employee updateEmployee(EmployeeDto employeeDto);

}
