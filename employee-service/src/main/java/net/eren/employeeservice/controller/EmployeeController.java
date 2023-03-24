package net.eren.employeeservice.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.eren.employeeservice.dto.APIResponseDto;
import net.eren.employeeservice.dto.EmployeeDto;
import net.eren.employeeservice.entitiy.Employee;
import net.eren.employeeservice.service.EmployeeService;
import net.eren.employeeservice.utils.ResponseMap;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private ModelMapper mapper;
    //Build save employee REST API
    @PostMapping
    public ResponseMap saveEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee=employeeService.saveEmployee(employeeDto);
        return ResponseMap.builder()
                .message("Employee created")
                .code("200")
                .details(Map.of("employee", mapper.map(employee, EmployeeDto.class)))
                .build();
    }
    @GetMapping("/{employeeId}")
    public ResponseMap getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        APIResponseDto apiResponseDto =employeeService.getEmployeeById(employeeId);
        return ResponseMap.builder()
                .message("Employee found")
                .code("200")
                .details(Map.of("employee", apiResponseDto))
                .build();
    }
}
