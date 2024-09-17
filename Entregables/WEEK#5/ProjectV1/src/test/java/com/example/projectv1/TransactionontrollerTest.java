package com.example.projectv1;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.projectv1.Controller.TransactionController;
import com.example.projectv1.Service.TransactionService;

class TransactionControllerTest {

    @InjectMocks
    private TransactionController transactionController;

    @Mock
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void transfer_ShouldReturnSuccess() {
        String sourceAccountNumber = "12345";
        String destinationAccountNumber = "67890";
        BigDecimal amount = BigDecimal.valueOf(100.00);
        
        // Configurar el servicio para que no lance ninguna excepción
        doNothing().when(transactionService).transfer(sourceAccountNumber, destinationAccountNumber, amount);

        ResponseEntity<String> response = transactionController.transfer(sourceAccountNumber, destinationAccountNumber, amount);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Transfer completed successfully", response.getBody());
        verify(transactionService, times(1)).transfer(sourceAccountNumber, destinationAccountNumber, amount);
    }

    @Test
    void transfer_ShouldReturnBadRequest_WhenExceptionOccurs() {
        String sourceAccountNumber = "12345";
        String destinationAccountNumber = "67890";
        BigDecimal amount = BigDecimal.valueOf(100.00);
        
        // Configurar el servicio para que lance una excepción
        doThrow(new RuntimeException("Transfer failed")).when(transactionService).transfer(sourceAccountNumber, destinationAccountNumber, amount);

        ResponseEntity<String> response = transactionController.transfer(sourceAccountNumber, destinationAccountNumber, amount);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Transfer failed", response.getBody());
        verify(transactionService, times(1)).transfer(sourceAccountNumber, destinationAccountNumber, amount);
    }
}
