package net.eren.employeeservice.service.Impl;

import lombok.AllArgsConstructor;
import net.eren.employeeservice.dto.APIResponseDto;
import net.eren.employeeservice.dto.DepartmentDto;
import net.eren.employeeservice.dto.EmployeeDto;
import net.eren.employeeservice.entitiy.Employee;
import net.eren.employeeservice.repo.EmployeeRepository;
import net.eren.employeeservice.service.APIClient;
import net.eren.employeeservice.service.EmployeeService;
import net.eren.employeeservice.utils.ResponseMap;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;
    //  private  RestTemplate restTemplate;
    // private final WebClient webClient;
    private final APIClient apiClient;

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapper.map(employeeDto, Employee.class);
        Employee employee1 = employeeRepository.findByEmail(employee.getEmail());
        if (employee1 != null) {
            throw new RuntimeException("Employee already exists");
        } else {
            Employee employee2 = employeeRepository.save(employee);
            return employee2;
        }
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
        ResponseMap responseMap = apiClient.getDepartmentByCode(employee.getDepartmentCode());
        DepartmentDto departmentDto = mapper.map(responseMap.getDetails().get("department"), DepartmentDto.class);
/*
        ResponseMap responseMap = webClient.get()
                .uri("http://localhost:8090/api/departments/" + employee.getDepartmentCode())
                .retrieve().bodyToMono(ResponseMap.class)
                .block();
        DepartmentDto departmentDto = mapper.map(responseMap.getDetails().get("department"), DepartmentDto.class);
*/
/*
        ResponseMap responseMap = restTemplate.getForEntity("http://localhost:8090/api/departments/" + employee.getDepartmentCode(), ResponseMap.class).getBody();
        DepartmentDto departmentDto = mapper.map(responseMap.getDetails().get("department"), DepartmentDto.class);
*/
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setEmployeeDto(employeeDto);

        return apiResponseDto;
    }

    @Override
    public Employee getEmployeeByCode(String employeeCode) {
        return null;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return null;
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {

    }

    @Override
    public Employee updateEmployee(EmployeeDto employeeDto) {
        return null;
    }

}
