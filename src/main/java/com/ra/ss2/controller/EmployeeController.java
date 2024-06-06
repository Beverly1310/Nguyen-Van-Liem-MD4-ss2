package com.ra.ss2.controller;

import com.ra.ss2.model.Employee;
import com.ra.ss2.model.dto.EmployeeRequest;
import com.ra.ss2.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Employee>> searchEmployee(@PathVariable(value = "name",required = false) String name) {
        return new ResponseEntity<>(employeeService.getEmployeeByName(name), HttpStatus.OK);
    }
    @GetMapping("/salary")
    public ResponseEntity<List<Employee>> getEmployeeSalary(@RequestParam(value = "minSalary",defaultValue = "0") Double minSalary,
                                                             @RequestParam(value = "maxSalary",defaultValue = "0") Double maxSalary) {
      return new ResponseEntity<>(employeeService.getEmployeesBySalaryBetween(minSalary,maxSalary),HttpStatus.OK);
    }
    @GetMapping("/searchbyname")
    public ResponseEntity<List<Employee>> searchEmployeeByNameWithPagingAndSalaryDesc(@RequestBody EmployeeRequest employeeRequest){
        List<Employee> list = employeeService.getEmployeesByFullNameWithPagingAndSortingDescendingBySalary(employeeRequest.getFullName(),employeeRequest.getPage()-1,employeeRequest.getItemPage());
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/gettop10salary")
    public ResponseEntity<List<Employee>> getTop10Salary(){
     return new ResponseEntity<>(employeeService.getTopBySalary(),HttpStatus.OK);
    }
}
