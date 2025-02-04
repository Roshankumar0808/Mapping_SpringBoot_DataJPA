package com.Mapping_SpringBoot_JPA.Mapping_SpringBoot_JPA.Entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employee_Table")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;
}
