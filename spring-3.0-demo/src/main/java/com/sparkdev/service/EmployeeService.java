package com.sparkdev.service;

import com.sparkdev.dto.Employee;
import com.sparkdev.exceptions.NotFoundException;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    //Observation Registry feature to publish the metrics
    @Autowired
    private ObservationRegistry observationRegistry;
    public Employee save(Employee employee){
        employees.add(employee);
        return Observation.createNotStarted("SaveEmployee", observationRegistry).observe(() -> employee);
    }

    public List<Employee> getAllEmployees(){
        return Observation.createNotStarted("getAllEmployees",observationRegistry).observe(()->employees);
    }

    public Employee getEmployeeById(int id)  {
        return Observation.createNotStarted("getEmployeeById",observationRegistry)
                .observe(() -> employees.stream().filter(employee -> employee.id() == id)
                        .findAny()
                        .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND, "employee with the given id "+id+" not found !")));
    }
}
