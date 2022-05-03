package RegresionLineal;

import Algorithm.modelo.RegresionLineal.RegresionLineal;
import Excepciones.DifferentFieldNumberInRawException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import CSV.CSV;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test de la clase RegresionLineal")
public class RegresionLinealTest {

    @Test
    @DisplayName("Test de la clase RegresionLineal")
    void RegresionLinealTest() throws IOException, DifferentFieldNumberInRawException {
            RegresionLineal rl = new RegresionLineal();
            rl.train(CSV.readTable("src/main/resources/miles_dollars.csv"));
            assertEquals(1.255, Math.round(rl.getAlpha() * 1000.0) / 1000.0);
            assertEquals(274.85, Math.round(rl.getBeta() * 1000.0) / 1000.0);
    }
}
