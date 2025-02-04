package com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Repositories;

import com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
