package com.berkan.Spring_rest.controller;

import com.berkan.Spring_rest.entity.Employee;
import com.berkan.Spring_rest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployeeList(){
      return   employeeService.getAllEmployeeList();

    }
    @GetMapping(path = "/list/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id",required = true) String id){
        return  employeeService.getEmployeeById(id);

    }
    @GetMapping(path = "/with-params")
    public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName" , required = false) String firstName,
                                                @RequestParam(name ="lastName" ,required = false) String lastName){
        return  employeeService.getEmployeeWithParams(firstName,lastName);
    }
    @PostMapping(path = "/save-employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);

    }
    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id", required = true) String id){
        return employeeService.deleteEmployee(id);
    }
}
