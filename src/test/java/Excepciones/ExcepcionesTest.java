package Excepciones;

import CSV.Row;
import CSV.Table;
import CSV.TableWithLabels;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test de las excepciones.")
public class ExcepcionesTest {
    @Test
    @DisplayName("Test de la clase EmptyTableException")
    void EmptyTableExceptionTest() {
        assertThrows(EmptyTableException.class, () -> new Table(null));
        List<List<String>> lista = new ArrayList<>();
        lista.clear();
        assertThrows(EmptyTableException.class, () -> new Table(lista));

        assertThrows(EmptyTableException.class, () -> new TableWithLabels(null, null));

        assertThrows(EmptyTableException.class, () -> new TableWithLabels(lista, null));

    }

    void ZeroDivisionExceptionTest() {


    }
}
