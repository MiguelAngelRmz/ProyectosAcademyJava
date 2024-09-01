package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDatabaseExample {

    private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Crear tabla de empleados si no existe
            createEmployeeTable(connection);

            // Añadir empleados
            addEmployee(connection, "John", "Doe", "john.doe@example.com");
            addEmployee(connection, "Jane", "Smith", "jane.smith@example.com");

            // Imprimir lista de empleados
            System.out.println("Lista de empleados después de añadir:");
            printEmployees(connection);

            // Eliminar un empleado
            deleteEmployee(connection, "john.doe@example.com");

            // Imprimir lista de empleados después de eliminar
            System.out.println("Lista de empleados después de eliminar:");
            printEmployees(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createEmployeeTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS employees (" +
                                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                "first_name VARCHAR(50), " +
                                "last_name VARCHAR(50), " +
                                "email VARCHAR(100) UNIQUE)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
        }
    }

    private static void addEmployee(Connection connection, String firstName, String lastName, String email) throws SQLException {
        String insertSQL = "INSERT INTO employees (first_name, last_name, email) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
        }
    }

    private static void printEmployees(Connection connection) throws SQLException {
        String selectSQL = "SELECT id, first_name, last_name, email FROM employees";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                
                System.out.printf("ID: %d, Nombre: %s %s, Email: %s%n", id, firstName, lastName, email);
            }
        }
    }

    private static void deleteEmployee(Connection connection, String email) throws SQLException {
        String deleteSQL = "DELETE FROM employees WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.executeUpdate();
        }
    }
}
