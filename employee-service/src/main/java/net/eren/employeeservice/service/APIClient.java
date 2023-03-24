package net.eren.employeeservice.service;

import net.eren.employeeservice.utils.ResponseMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("/api/departments/{departmentCode}")
    ResponseMap getDepartmentByCode( @PathVariable String departmentCode);

}
