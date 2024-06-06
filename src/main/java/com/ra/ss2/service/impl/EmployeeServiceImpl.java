package com.ra.ss2.service.impl;

import com.ra.ss2.model.Employee;
import com.ra.ss2.repository.EmployeeRepository;
import com.ra.ss2.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Employee not found"));
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer id) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
          employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        if (name == null || name.isEmpty()) {
            return employeeRepository.findAll();
        } else {
            return employeeRepository.findByName(name);

        }
    }

    @Override
    public List<Employee> getEmployeesBySalaryBetween(Double minSalary, Double maxSalary) {
        return employeeRepository.getEmployeesBySalaryBetween(minSalary, maxSalary);
    }

    @Override
    public List<Employee> getEmployeesByFullNameWithPagingAndSortingDescendingBySalary(String searchName, Integer page, Integer itemPage) {
        Pageable pageable = PageRequest.of(page, itemPage);
        if (searchName == null || searchName.isEmpty()) {
            return employeeRepository.findAll(pageable).getContent();
        } else {
            return employeeRepository.getEmployeesByFullNameWithPagingAndSortingDescendingBySalary(searchName, pageable);
        }
    }

    @Override
    public List<Employee> getTopBySalary() {
        return employeeRepository.getTopBySalary();
    }
}
