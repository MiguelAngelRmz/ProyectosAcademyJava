package com.example.projectv1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

   

        @Test
    @WithMockUser(username = "user", roles = {"USER"}, password = "password") // Usuario "USER" no debería acceder a transacciones
    void testTransactionAccessAccessForUserRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/transactions/transfer")
                .param("sourceAccountNumber", "18131049")
                .param("destinationAccountNumber", "1234567890")
                .param("amount", "10.00")) // Parámetros necesarios
                .andExpect(status().isForbidden()); // Verificamos que sea 403 Forbidden
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"}, password = "admin")
    void testTransactionAccessWithAdminRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/transactions/transfer")
                .param("sourceAccountNumber", "18131049")
                .param("destinationAccountNumber", "1234567890")
                .param("amount", "10.00")) // Parámetros necesarios
                .andExpect(status().isOk()); // Espera un 200 OK
    }

}
