package Algorithm.Kmeans;

import Algorithm.Algorithm;
import CSV.Row;
import CSV.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kmeans implements Algorithm<Table, String, Row> {
    int numberClusters;
    int iteractions;
    long seed;

    public Kmeans() {
    }

    public Kmeans(int numberClusters, int iteractions, long seed){
        this.numberClusters = numberClusters;
        this.iteractions = iteractions;
        this.seed = seed;
    }

    @Override
    public void train(Table tabla){

        Random random = new Random(seed);

        List<Row> centroides = new ArrayList<>();
        for(int i = 0; i<numberClusters; i++){
            Row row = tabla.getRowAt(random.nextInt());
            if (!centroides.contains(row)){
                centroides.add(row);
            }
        }


    }

    @Override
    public String estimate(Row r){

    }
}
