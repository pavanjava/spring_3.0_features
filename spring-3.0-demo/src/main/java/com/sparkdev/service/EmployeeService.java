package com.sparkdev.service;

import com.sparkdev.dto.Employee;
import com.sparkdev.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    public Employee save(Employee employee){
        employees.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees(){
        return employees;
    }

    public Employee getEmployeeById(int id)  {
        return employees.stream().filter(employee -> employee.id() == id).findAny().orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND, "employee with the given id "+id+" not found !"));
    }
}
