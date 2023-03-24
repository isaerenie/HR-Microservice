package net.eren.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.eren.departmentservice.dto.DepartmentDto;
import net.eren.departmentservice.entitiy.Department;
import net.eren.departmentservice.service.Impl.DepartmentServiceImpl;
import net.eren.departmentservice.utils.ResponseMap;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;
    private final ModelMapper mapper;

    //Build save department REST API
    @PostMapping
    public ResponseMap saveDepartment(@RequestBody  DepartmentDto departmentDto) {
        Department department = departmentService.saveDepartment(departmentDto);
        return ResponseMap.builder()
                .message("Department created")
                .code("200")
                .details(Map.of("department", mapper.map(department, DepartmentDto.class)))
                .build();
    }
    // Build get department by code REST API
    @GetMapping("/{departmentCode}")
    public ResponseMap getDepartmentByCode(@PathVariable("departmentCode") String departmentCode) {
        Department department = departmentService.getDepartmentByCode(departmentCode);
        return ResponseMap.builder()
                .message("Department found")
                .code("200")
                .details(Map.of("department", mapper.map(department, DepartmentDto.class)))
                .build();
    }
}
