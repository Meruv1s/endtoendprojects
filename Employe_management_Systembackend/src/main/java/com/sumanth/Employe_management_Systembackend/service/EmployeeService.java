package com.sumanth.Employe_management_Systembackend.service;

import com.sumanth.Employe_management_Systembackend.dto.EmployeeDto;
import com.sumanth.Employe_management_Systembackend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto>  getAll();
    EmployeeDto updateEmployee (Long employeeId, EmployeeDto updatedEmployee);
    void deleteEmployee (Long employeeId);
}
