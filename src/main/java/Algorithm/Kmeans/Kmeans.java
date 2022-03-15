package Algorithm.Kmeans;

import Algorithm.Algorithm;
import CSV.Row;
import CSV.Table;

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

        for(int i = 0; i<numberClusters; i++){
            Row r = tabla.getRowAt(random.nextInt());
        }

    }

    @Override
    public String estimate(Row r){

    }
}
