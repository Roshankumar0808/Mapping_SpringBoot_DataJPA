package com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Services;

import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Entities.DepartmentEntity;
import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Entities.EmployeeEntity;
import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Repositories.DepartmentRepository;
import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    private  final DepartmentRepository departmentRepository;
    private  final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity){
        return departmentRepository.save(departmentEntity);
   }

    public DepartmentEntity getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }


    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long employeeId) {
       Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentId);
       Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);
      return departmentEntity.flatMap(department->
              employeeEntity.map(employee->{
          department.setManager(employee);
          return departmentRepository.save(department);
      })).orElse(null);
    }

    public DepartmentEntity getassignedDepartmentOfManager(Long employeeId) {
        //Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);
        //return employeeEntity.map(employee->employee.getManagedDepartment()).orElse(null);
        EmployeeEntity employeeEntity=EmployeeEntity.builder().id(employeeId).build();
        return departmentRepository.findByManager(employeeEntity);
    }

    public DepartmentEntity assignWorkerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity>departmentEntity=departmentRepository.findById(departmentId);
        Optional<EmployeeEntity>employeeEntity=employeeRepository.findById(employeeId);
        return departmentEntity.flatMap(department->employeeEntity.map(employee->{
            employee.setWorkerDepartment(department);
            employeeRepository.save(employee);
            department.getWorkers().add(employee);
            return department;
        })).orElse(null);
    }
}
