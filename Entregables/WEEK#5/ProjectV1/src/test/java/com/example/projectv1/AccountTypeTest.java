package com.example.projectv1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.projectv1.Entity.AccountType;

class AccountTypeTest {

    @Test
    void testEnumValues() {
        // Verificar que los valores del enum son los esperados
        assertEquals(2, AccountType.values().length);
        assertEquals(AccountType.SAVINGS, AccountType.valueOf("SAVINGS"));
        assertEquals(AccountType.CHECKING, AccountType.valueOf("CHECKING"));
    }

    @Test
    void testEnumName() {
        // Verificar que el nombre del enum es el esperado
        assertEquals("SAVINGS", AccountType.SAVINGS.name());
        assertEquals("CHECKING", AccountType.CHECKING.name());
    }

    @Test
    void testEnumOrdinal() {
        // Verificar que el ordinal del enum es el esperado
        assertEquals(0, AccountType.SAVINGS.ordinal());
        assertEquals(1, AccountType.CHECKING.ordinal());
    }

    @Test
    void testEnumComparison() {
        // Verificar la comparación entre los valores del enum
        assertTrue(AccountType.SAVINGS != AccountType.CHECKING);
        assertTrue(AccountType.SAVINGS == AccountType.SAVINGS);
    }
}
