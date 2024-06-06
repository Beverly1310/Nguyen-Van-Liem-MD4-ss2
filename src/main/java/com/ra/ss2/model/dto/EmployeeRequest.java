package com.ra.ss2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeRequest {
    private String fullName;
    private Integer page;
    private Integer itemPage;
}
