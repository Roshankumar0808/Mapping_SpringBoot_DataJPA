package com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Department_Table")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(name = "department_manager")
    private EmployeeEntity manager;

    @OneToMany(mappedBy = "workerDepartment",fetch = FetchType.LAZY)

    private Set<EmployeeEntity> workers;


    @ManyToMany(mappedBy = "freelanceDepartments")
   private Set<EmployeeEntity>freelancers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepartmentEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle());
    }
}
