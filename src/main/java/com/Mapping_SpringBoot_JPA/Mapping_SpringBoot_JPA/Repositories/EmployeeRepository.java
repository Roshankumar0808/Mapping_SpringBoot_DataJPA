package com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Repositories;

import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
