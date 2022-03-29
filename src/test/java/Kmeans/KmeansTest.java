package Kmeans;

import Algorithm.KNN.KNN;
import Algorithm.Kmeans.Kmeans;
import Algorithm.distance.Distance;
import Algorithm.distance.DistanceType;
import Algorithm.distance.EuclideanDistance;
import Algorithm.distance.ManhattanDistance;
import Algorithm.factory.DistanceFactory;
import Excepciones.DifferentFieldNumberInRawException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import CSV.CSV;
import CSV.Row;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test de la clase Kmeans")
public class KmeansTest {

    @Test
    @DisplayName("Test de la clase Kmeans")
    void meansTest() throws IOException, DifferentFieldNumberInRawException {
        DistanceFactory factory = new DistanceFactory();
        Distance distance = factory.getDistance(DistanceType.EUCLIDEAN);
        Kmeans kmeans = new Kmeans(3,10,5, distance);
        kmeans.train(CSV.readTable("src/main/resources/iris_not_labels.csv"));
        List<String> l = new ArrayList<>();
        l.add("4.8");l.add("3.0");l.add("1.1");l.add("0.1");
        assertEquals("cluster-0", kmeans.estimate(new Row(l)));

        distance = factory.getDistance(DistanceType.MANHATTAM);
        kmeans.setDistance(distance);
        assertEquals("cluster-0", kmeans.estimate(new Row(l)));



    }
}