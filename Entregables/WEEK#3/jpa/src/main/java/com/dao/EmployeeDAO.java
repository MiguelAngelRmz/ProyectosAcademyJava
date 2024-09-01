package com.dao;

import java.util.List;

import com.entity.Employee;

public interface EmployeeDAO {
    void save(Employee employee);

    Employee findById(int id);

    List<Employee> getAll();

    void delete(int id);
}
