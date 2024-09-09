package com.jpacrud.repository;

import com.jpacrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class EmployeeRepository {
    private final EntityManager entityManager;

    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Employee addEmployee(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
        return employee;
    }

    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee", Employee.class);
        return query.getResultList();
    }

    public void deleteEmployee(Long employeeId) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Employee employee = entityManager.find(Employee.class, employeeId);
        if (employee != null) {
            entityManager.remove(employee);
        }
        transaction.commit();
    }

    public Employee getEmployee(Long employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }
}
