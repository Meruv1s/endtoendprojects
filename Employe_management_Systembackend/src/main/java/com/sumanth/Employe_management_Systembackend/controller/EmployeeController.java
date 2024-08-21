package com.sumanth.Employe_management_Systembackend.controller;

import com.sumanth.Employe_management_Systembackend.dto.EmployeeDto;
import com.sumanth.Employe_management_Systembackend.entity.Employee;
import com.sumanth.Employe_management_Systembackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
   @Autowired
   private EmployeeService employeeService;

   @PostMapping
   public ResponseEntity<EmployeeDto> createEmployee ( @RequestBody EmployeeDto employeeDto)
   {
       EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
     return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

   }
   @GetMapping("{id}")
  public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId)

  { EmployeeDto employeeDto =employeeService.getEmployeeById(employeeId);

      return new ResponseEntity<>(employeeDto, HttpStatus.OK);

  }

   @GetMapping
  public ResponseEntity<List<EmployeeDto>>  getALL()
  {
      List<EmployeeDto> employees = employeeService.getAll();
      return  new ResponseEntity<>(employees,HttpStatus.OK);
  }
    @PutMapping("{id}")

    public ResponseEntity<EmployeeDto> updateEmployee (@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee) {

        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable ("id") Long employeeId) {

        employeeService.deleteEmployee(employeeId);

        return ResponseEntity.ok("Employee deleted successfully!.");
    }
}
