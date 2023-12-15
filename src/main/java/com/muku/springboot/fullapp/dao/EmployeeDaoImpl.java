package com.muku.springboot.fullapp.dao;

import com.muku.springboot.fullapp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager1){
        entityManager = entityManager1;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> list1 = theQuery.getResultList();
        return list1;

    }

    @Override
    public Employee findById(int id) {
        Employee emp1 = entityManager.find(Employee.class, id);

        return emp1;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmp = entityManager.merge(employee);
        return dbEmp;
    }

    @Override
    public void deleteById(int id) {
        Employee emp1 = entityManager.find(Employee.class, id);
        entityManager.remove(emp1);

    }
}
