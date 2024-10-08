package com.berkan.Spring_rest.config;


import com.berkan.Spring_rest.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList(){

        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee("1","berkan","sevil"));
        employeeList.add(new Employee("2","selim","kurtulan"));
        employeeList.add(new Employee("3","ahmet","yesevi"));
        employeeList.add(new Employee("4","kemal","mıdık"));
        employeeList.add(new Employee("5","kemal","sevil"));

        return employeeList;
    }

}
