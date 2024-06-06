package com.ra.ss2.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private Boolean gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String address;
    private String company;
    private String department;
    private Double salary;
}
