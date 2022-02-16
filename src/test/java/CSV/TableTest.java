package CSV;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practica1.CSV.Row;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test de la clase Table")
public class TableTest {


    @Test
    @DisplayName("Test de la clase Row")
    void RowTest(){
        List<String> doubles = new ArrayList<>();
        doubles.add("1.2"); doubles.add("2.3"); doubles.add("3.4");

        Row row = new Row(doubles);

        assertEquals(doubles, row.getData());
    }
}
