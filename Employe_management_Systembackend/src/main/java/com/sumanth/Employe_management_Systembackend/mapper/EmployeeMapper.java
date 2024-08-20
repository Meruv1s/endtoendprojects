package com.sumanth.Employe_management_Systembackend.mapper;

import com.sumanth.Employe_management_Systembackend.EmployeManagementSystembackendApplication;
import com.sumanth.Employe_management_Systembackend.dto.EmployeeDto;
import com.sumanth.Employe_management_Systembackend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee)

    {
        return new EmployeeDto(employee.getId(),employee.getFirstname(),employee.getLastname(),employee.getEmail());
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto)

    {
        return new Employee(employeeDto.getId(),employeeDto.getFirstname(),employeeDto.getLastname(),employeeDto.getEmail());
    }
}
