package com.sumanth.Employe_management_Systembackend.repository;

import com.sumanth.Employe_management_Systembackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
