package com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Services;

import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Entities.DepartmentEntity;
import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private  final DepartmentRepository departmentRepository;
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

   public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity){
        return departmentRepository.save(departmentEntity);
   }

    public DepartmentEntity getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }


}
