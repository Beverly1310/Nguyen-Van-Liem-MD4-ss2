package com.ra.ss2.repository;

import com.ra.ss2.model.Employee;
import com.ra.ss2.model.dto.EmployeeRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, PagingAndSortingRepository<Employee, Integer> {
    @Query("select e from Employee e where e.fullName like concat('%',:name,'%') ")
     List<Employee> findByName(String name);
        @Query("select e from Employee e where e.salary between :minSalary and :maxSalary")
    List<Employee> getEmployeesBySalaryBetween(Double minSalary, Double maxSalary);
    @Query("select e from Employee e where e.fullName like concat('%',:name,'%') order by e.salary desc ")
     List<Employee> getEmployeesByFullNameWithPagingAndSortingDescendingBySalary(String name, Pageable pageable);
    @Query("select e from Employee e order by e.salary desc limit 10")
    List<Employee> getTopBySalary();
}
