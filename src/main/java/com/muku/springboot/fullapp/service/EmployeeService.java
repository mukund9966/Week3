package com.muku.springboot.fullapp.service;

import com.muku.springboot.fullapp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
