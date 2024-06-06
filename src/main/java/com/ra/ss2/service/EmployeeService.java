package com.ra.ss2.service;

import com.ra.ss2.model.Employee;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee, Integer id);
    void deleteEmployee(Integer id);
    List<Employee> getEmployeeByName(String name);
    List<Employee> getEmployeesBySalaryBetween(Double minSalary, Double maxSalary);
    List<Employee> getEmployeesByFullNameWithPagingAndSortingDescendingBySalary(String searchName, Integer page, Integer itemPage);
    List<Employee> getTopBySalary();
}
