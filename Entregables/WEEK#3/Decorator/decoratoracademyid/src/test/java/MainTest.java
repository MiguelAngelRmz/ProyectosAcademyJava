import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.decorator.Main;

public class MainTest {

    @Test
    void testMain() {
        // Captura la salida del sistema
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; // Guarda el PrintStream original
        System.setOut(new PrintStream(outContent));

        try {
            // Ejecuta el método main
            Main.main(new String[]{});
        } finally {
            // Restaura el PrintStream original
            System.setOut(originalOut);
        }

        // Obtén el resultado de la salida estándar
        String output = outContent.toString().trim();

        // Resultado esperado de la salida estándar
        String expectedOutput = "Subscription: Basic Subscription, No Ads, Offline Downloads, Premium Content\n"
                              + "Total Cost: $15.24\n";

        // Normaliza las cadenas y verifica que la salida capturada sea la esperada
        assertEquals(expectedOutput.trim(), output);
    }
}