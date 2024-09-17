package com.example.projectv1;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.example.projectv1.Entity.Customer;
import com.example.projectv1.Repo.CustomerRepo;
import com.example.projectv1.Service.CustomerService;

public class CustomerServiceTest {

    @Mock
    private CustomerRepo customerRepo;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializar los mocks
    }

    // Test para createCustomer
    @Test
    public void testCreateCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setAccounts(new HashSet<>());  // Relación de cuentas vacía para el test

        when(customerRepo.save(any(Customer.class))).thenReturn(customer); // Simular el comportamiento del repositorio

        // Act
        Customer createdCustomer = customerService.createCustomer(customer);

        // Assert
        assertEquals(customer, createdCustomer);
        verify(customerRepo, times(1)).save(customer); // Verificar que se llamó al método save una vez
    }

    // Test para getAllCustomers
    @Test
    public void testGetAllCustomers() {
        // Arrange
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setName("John Doe");
        customer1.setEmail("john.doe@example.com");
        customer1.setAccounts(new HashSet<>());

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setName("Jane Doe");
        customer2.setEmail("jane.doe@example.com");
        customer2.setAccounts(new HashSet<>());

        List<Customer> customerList = List.of(customer1, customer2);
        when(customerRepo.findAll()).thenReturn(customerList); // Simular el comportamiento del repositorio

        // Act
        List<Customer> customers = customerService.getAllCustomer();

        // Assert
        assertEquals(2, customers.size());
        assertEquals(customerList, customers);
        verify(customerRepo, times(1)).findAll(); // Verificar que se llamó al método findAll una vez
    }

    // Test para getCustomerById
    @Test
    public void testGetCustomerById() {
        // Arrange
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setAccounts(new HashSet<>());

        when(customerRepo.findById(1L)).thenReturn(Optional.of(customer)); // Simular el comportamiento del repositorio

        // Act
        Optional<Customer> foundCustomer = customerService.getCustomerById(1L);

        // Assert
        assertEquals(Optional.of(customer), foundCustomer);
        verify(customerRepo, times(1)).findById(1L); // Verificar que se llamó al método findById una vez
    }

    // Test para getCustomerById cuando el cliente no se encuentra
    @Test
    public void testGetCustomerByIdNotFound() {
        // Arrange
        when(customerRepo.findById(1L)).thenReturn(Optional.empty()); // Simular el comportamiento del repositorio

        // Act
        Optional<Customer> foundCustomer = customerService.getCustomerById(1L);

        // Assert
        assertEquals(Optional.empty(), foundCustomer);
        verify(customerRepo, times(1)).findById(1L); // Verificar que se llamó al método findById una vez
    }
}