package com.example.projectv1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.projectv1.Entity.TransactionType;

class TransactionTypeTest {

    @Test
    void testEnumValues() {
        // Verificar que los valores del enum son los esperados
        assertEquals(3, TransactionType.values().length);
        assertEquals(TransactionType.DEPOSIT, TransactionType.valueOf("DEPOSIT"));
        assertEquals(TransactionType.WITHDRAWAL, TransactionType.valueOf("WITHDRAWAL"));
        assertEquals(TransactionType.TRANSFER, TransactionType.valueOf("TRANSFER"));
    }

    @Test
    void testEnumName() {
        // Verificar que el nombre del enum es el esperado
        assertEquals("DEPOSIT", TransactionType.DEPOSIT.name());
        assertEquals("WITHDRAWAL", TransactionType.WITHDRAWAL.name());
        assertEquals("TRANSFER", TransactionType.TRANSFER.name());
    }

    @Test
    void testEnumOrdinal() {
        // Verificar que el ordinal del enum es el esperado
        assertEquals(0, TransactionType.DEPOSIT.ordinal());
        assertEquals(1, TransactionType.WITHDRAWAL.ordinal());
        assertEquals(2, TransactionType.TRANSFER.ordinal());
    }

    @Test
    void testEnumComparison() {
        // Verificar la comparación entre los valores del enum
        assertTrue(TransactionType.DEPOSIT != TransactionType.WITHDRAWAL);
        assertTrue(TransactionType.WITHDRAWAL != TransactionType.TRANSFER);
        assertTrue(TransactionType.DEPOSIT == TransactionType.DEPOSIT);
    }
}
