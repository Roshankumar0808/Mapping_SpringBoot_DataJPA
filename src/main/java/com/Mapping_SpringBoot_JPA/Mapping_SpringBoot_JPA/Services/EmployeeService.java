package com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Services;

import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Entities.DepartmentEntity;
import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Entities.EmployeeEntity;
import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Repositories.DepartmentRepository;
import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private  final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }




    public EmployeeEntity createNewDepartment(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity getDepartmentById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

}
