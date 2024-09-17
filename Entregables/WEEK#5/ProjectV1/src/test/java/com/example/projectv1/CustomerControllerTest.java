package com.example.projectv1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.projectv1.Controller.CustomerController;
import com.example.projectv1.Entity.Customer;
import com.example.projectv1.Service.CustomerService;

class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCustomer_ShouldReturnCreatedCustomer() {
        // Crear el objeto Customer de prueba
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");
        customer.setEmail("johndoe@example.com");
        customer.setAccounts(new HashSet<>());  // Inicializar el conjunto de cuentas

        // Simular el comportamiento del servicio
        when(customerService.createCustomer(any(Customer.class))).thenReturn(customer);

        // Llamar al método del controlador
        ResponseEntity<Customer> response = customerController.createCustomer(customer);

        // Verificar la respuesta
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    void getCustomerById_ShouldReturnCustomer() {
        Long id = 1L;
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("John Doe");
        customer.setEmail("johndoe@example.com");
        customer.setAccounts(new HashSet<>());  // Inicializar el conjunto de cuentas

        when(customerService.getCustomerById(id)).thenReturn(Optional.of(customer));

        ResponseEntity<Customer> response = customerController.getCustomerById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    void getCustomerById_ShouldReturnNotFound() {
        Long id = 1L;

        when(customerService.getCustomerById(id)).thenReturn(Optional.empty());

        ResponseEntity<Customer> response = customerController.getCustomerById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void getAllCustomers_ShouldReturnListOfCustomers() {
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setName("John Doe");
        customer1.setEmail("johndoe@example.com");
        customer1.setAccounts(new HashSet<>());  // Inicializar el conjunto de cuentas
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setName("Jane Doe");
        customer2.setEmail("janedoe@example.com");
        customer2.setAccounts(new HashSet<>());  // Inicializar el conjunto de cuentas
        customers.add(customer2);

        when(customerService.getAllCustomer()).thenReturn(customers);

        ResponseEntity<List<Customer>> response = customerController.getAllCustomers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customers, response.getBody());
    }
}
