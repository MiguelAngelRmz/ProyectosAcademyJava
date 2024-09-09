package com.jpacrud;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.jpacrud.repository.EmployeeRepository;
import com.jpacrud.entity.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EmployeeRepository employeeRepository = new EmployeeRepository(entityManager);

        // Crear y añadir empleados
        Employee emp1 = new Employee();
        emp1.setFirstName("John");
        emp1.setLastName("Doe");
        emp1.setEmail("john.doe@example.com");

        Employee emp2 = new Employee();
        emp2.setFirstName("Jane");
        emp2.setLastName("Smith");
        emp2.setEmail("jane.smith@example.com");

        employeeRepository.addEmployee(emp1);
        employeeRepository.addEmployee(emp2);

        // Imprimir todos los empleados
        System.out.println("Empleados añadidos:");
        printEmployees(employeeRepository.getAllEmployees());

        // Eliminar un empleado
        employeeRepository.deleteEmployee(emp1.getId());

        // Imprimir todos los empleados después de la eliminación
        System.out.println("Empleados después de la eliminación:");
        printEmployees(employeeRepository.getAllEmployees());

        // Cerrar la conexión
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
