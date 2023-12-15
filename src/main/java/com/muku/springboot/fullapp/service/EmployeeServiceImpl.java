package com.muku.springboot.fullapp.service;

import com.muku.springboot.fullapp.dao.EmployeeDao;
import com.muku.springboot.fullapp.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

private EmployeeDao employeeDao;
@Autowired
public EmployeeServiceImpl(EmployeeDao employeeDao1){
    employeeDao = employeeDao1;
}
    @Override
    public List<Employee> findAll() {
    return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
return employeeDao.findById(id);    }
@Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }
@Transactional
    @Override
    public void deleteById(int id) {
 employeeDao.deleteById(id);
    }
}
