package CSV;

import Excepciones.DifferentFieldNumberInRawException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test de la clase CSV")
public class CSVTest {

    @Test
    @DisplayName("Test de la clase Row")
    void RowTest() {
        List<String> doubles = new ArrayList<>();
        doubles.add("1.2");
        doubles.add("2.3");
        doubles.add("3.4");

        Row row = new Row(doubles);

        assertEquals(doubles.toString(), row.getData().toString());
    }

    @Test
    @DisplayName("Test de la clase RowWithLabels")
    void RowWithLabelsTest() {
        List<String> fila = new ArrayList<>();
        fila.add("1.2");
        fila.add("2.3");
        fila.add("3.4");

        RowWithLabel row = new RowWithLabel(fila, "etiqueta");

        assertEquals(fila.toString(), row.getData().toString());
        assertEquals("etiqueta", row.getLabel());
    }

    @Test
    @DisplayName("Test de la clase Table")
    void TableTest() throws IOException, DifferentFieldNumberInRawException {
        Table table = CSV.readTable("src/main/resources/miles_dollars.csv");
        assertEquals(25, table.size());
        assertEquals("[1849.0, 2332.0]", table.getRowAt(4).toString());
        assertEquals(2, table.rowSize());
    }

    @Test
    @DisplayName("Test de la clase TableWithLabels")
    void TableWithLabelsTest() throws IOException, DifferentFieldNumberInRawException {
        TableWithLabels table = CSV.readTableWithLabels("src/main/resources/iris.csv");
        assertEquals(150, table.size());
        assertEquals("[5.0, 3.6, 1.4, 0.2]", table.getRowAt(4).toString());
        assertEquals("Iris-setosa", table.getRowAt(4).getLabel().toString());
    }
}
