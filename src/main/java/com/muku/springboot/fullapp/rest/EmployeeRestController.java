package com.muku.springboot.fullapp.rest;

import com.muku.springboot.fullapp.dao.EmployeeDao;
import com.muku.springboot.fullapp.entity.Employee;
import com.muku.springboot.fullapp.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService1){
        employeeService = employeeService1;
    }

    @GetMapping("/employees")
    public List<Employee> findall(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")

    public Employee getEmployee(@PathVariable int employeeId){
        Employee theemp = employeeService.findById(employeeId);
        if(theemp==null){
            throw new RuntimeException("not valid emp id"+ employeeId);
        }
        return theemp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theemp){
        theemp.setId(0);
        Employee dbEmp = employeeService.save(theemp);
        return dbEmp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theemp){
        Employee emp = employeeService.save(theemp);
        return emp;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee emp = employeeService.findById(employeeId);
        if(emp==null){
            throw new RuntimeException("not found id");
        }
        employeeService.deleteById(employeeId);
        return "deleted employee"+ employeeId;
    }
}
