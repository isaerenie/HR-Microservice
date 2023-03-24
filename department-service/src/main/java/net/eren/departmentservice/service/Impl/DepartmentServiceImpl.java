package net.eren.departmentservice.service.Impl;

import lombok.AllArgsConstructor;
import net.eren.departmentservice.dto.DepartmentDto;
import net.eren.departmentservice.entitiy.Department;
import net.eren.departmentservice.repo.DepartmentRepository;
import net.eren.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper mapper;
    @Override
    public Department saveDepartment(DepartmentDto departmentDto) {
       Department department = mapper.map(departmentDto, Department.class);
       Department savedDepartment = departmentRepository.save(department);
         return savedDepartment;
    }

    @Override
    public Department findDepartmentById(Long departmentId) {
        return null;
    }

    @Override
    public Department getDepartmentByCode(String departmentCode) {
      Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return department;
    }

    @Override
    public List<Department> findAllDepartments() {
        return null;
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {

    }
}
