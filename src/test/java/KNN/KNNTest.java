package KNN;

import Algorithm.KNN.KNN;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import CSV.CSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test de la clase KNN")
public class KNNTest {

    @Test
    @DisplayName("Test de la clase KNN")
    void KNNTest() throws IOException {
        KNN knn = new KNN();
        knn.train(CSV.readTableWithLabels("src/main/resources/iris.csv"));
        List<Double> l = new ArrayList<>();
        l.add(4.8);l.add(3.0);l.add(1.4);l.add(0.2);
        assertEquals("Iris-setosa", knn.estimate(l));


    }
}
