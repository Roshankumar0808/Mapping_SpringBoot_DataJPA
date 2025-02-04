package com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Controllers;

import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Entities.DepartmentEntity;
import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Services.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
   public DepartmentEntity getDepartmentById(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity){
        return departmentService.createNewDepartment(departmentEntity);
    }



}
