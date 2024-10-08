package com.berkan.Spring_rest.repository;


import com.berkan.Spring_rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList(){

        return employeeList;
    }

    public Employee getEmployeeById(String id){
        Employee findEmployee=null;
        for (Employee employee:employeeList){
            if(id.equals(employee.getId())){
                findEmployee=employee;
                break;
            }
        }
        return findEmployee;
    }

    public List<Employee> getEmployeeWithParams(String firstName , String lastName){
        ArrayList<Employee> employeeWithParams=new ArrayList<>();
        if(firstName== null && lastName ==null){
            return employeeList;
        }
        for (Employee employee:employeeList){
            if(firstName!=null && lastName == null){
                if(firstName.equalsIgnoreCase(employee.getFirstName())){
                    employeeWithParams.add(employee);
                }
            }
            if(lastName!=null && firstName == null){
                if(lastName.equalsIgnoreCase(employee.getLastName())){
                    employeeWithParams.add(employee);
                }
            }
            if(firstName!= null && lastName!= null){
                if(firstName.equalsIgnoreCase(employee.getFirstName()) && lastName.equalsIgnoreCase(employee.getLastName())){
                    employeeWithParams.add(employee);
                }
            }

        }
        return employeeWithParams;
    }

   public Employee saveEmployee(Employee employee){
        employeeList.add(employee);
        return employee;
   }

   public boolean deleteEmployee(String id){
        Employee deleteEmployee=null;
       for (Employee employee:employeeList){
           if(id.equals(employee.getId())){
               deleteEmployee=employee;
               break;
           }
       }
       if(deleteEmployee==null){
           return false;
       }
       employeeList.remove(deleteEmployee);
        return true;
   }
}
