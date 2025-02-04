package com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Controllers;

import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Entities.DepartmentEntity;
import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Entities.EmployeeEntity;
import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Services.DepartmentService;
import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getDepartmentById(@PathVariable Long employeeId){
        return employeeService.getDepartmentById(employeeId);
    }

    @PostMapping
    public EmployeeEntity createNewDepartment(@RequestBody EmployeeEntity employeeEntity){
        return employeeService.createNewDepartment(employeeEntity);
    }
}
