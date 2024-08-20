package com.sumanth.Employe_management_Systembackend.service.impl;

import com.sumanth.Employe_management_Systembackend.dto.EmployeeDto;
import com.sumanth.Employe_management_Systembackend.entity.Employee;
import com.sumanth.Employe_management_Systembackend.exception.ResourceNotFoundException;
import com.sumanth.Employe_management_Systembackend.mapper.EmployeeMapper;
import com.sumanth.Employe_management_Systembackend.repository.EmployeeRepository;
import com.sumanth.Employe_management_Systembackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
 private EmployeeRepository employeeRepository;
   @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
      Employee savedEmployee=  employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
     Employee employee=  employeeRepository.findById(employeeId)
               .orElseThrow(()-> new ResourceNotFoundException("employee is not exists"+ employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAll() {
       List< Employee> employees= employeeRepository.findAll();
       return employees.stream()
               .map((emp)->EmployeeMapper.mapToEmployeeDto(emp)).collect(Collectors.toList());
    }


    // update
    @Override

    public EmployeeDto updateEmployee (Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(

                () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)

        );

        employee.setFirstname (updatedEmployee.getFirstname());

        employee.setLastname (updatedEmployee.getLastname());

        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployee0bj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto (updatedEmployee0bj);

    }
   @Override

    public void deleteEmployee (Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(

                () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)

        );

        employeeRepository.deleteById(employeeId);

    }
}
