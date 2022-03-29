package Algorithm.Kmeans;

import Algorithm.Algorithm;
import Algorithm.distance.Distance;
import Algorithm.distance.DistanceClient;
import CSV.Row;
import CSV.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Algorithm.KNN.KNN;

public class Kmeans implements Algorithm<Table, String, Row>, DistanceClient {
    int numberClusters;
    int iteractions;
    long seed;
    List<List<Row>> grupos;
    List<Row> centroides;
    Distance distance;

    public Kmeans(int numberClusters, int iteractions, long seed, Distance distance) {
        this.numberClusters = numberClusters;
        this.iteractions = iteractions;
        this.seed = seed;
        grupos = new ArrayList<List<Row>>();
        centroides = new ArrayList<Row>();
        this.distance = distance;
    }

    @Override
    public void train(Table tabla) {



        Random random = new Random(seed);
        for (int i = 0; i < numberClusters; i++) {
            int n = damenumeroAleatorio(random, tabla.size());
            Row row = tabla.getRowAt(n);
            grupos.add(new ArrayList<Row>());
            centroides.add(row);
        }

        for (int i = 0; i < iteractions; i++) {
            agrupa(tabla);
            recalculaCentroides();
        }


    }

    @Override
    public String estimate(Row r) {
        int grupo = calculaGrupo(r);
        return "cluster-" + grupo;
    }

    @Override
    public void setDistance(Distance distance){
        this.distance = distance;
    }


    private int damenumeroAleatorio(Random random, int tamanyo){

        int n = random.nextInt(tamanyo);
        return n;
    }

    private void agrupa(Table tabla) {
        for (Row row : tabla.getRows()) {
            int grupo = calculaGrupo(row);
            grupos.get(grupo).add(row);
        }
    }

    private int calculaGrupo (Row row) {
        double mejorDistancia = distance.calculateDistance(row.getData(), centroides.get(0).getData());
        int grupo = 0;
        for (int i = 1; i < centroides.size(); i++) {
            double distancia = distance.calculateDistance(row.getData(), centroides.get(i).getData());
            if (distancia < mejorDistancia) {
                mejorDistancia = distancia;
                grupo = i;
            }
        }
        return grupo;
    }

    private void recalculaCentroides() {
        for (int i = 0; i < centroides.size(); i++) {
            centroides.set(i, formulaCentroide(grupos.get(i)));
        }
    }

    private Row formulaCentroide(List<Row> grupo) {
        Row centroide;
        int tamanyoGrupo = grupo.size();
        List<Double> datos = new ArrayList<>();
        for (Row row : grupo) {
            List<Double> rowData = row.getData();
            for (int i = 0; i < rowData.size(); i++) {
                if (datos.size()<rowData.size()) {
                    datos.add(rowData.get(i));
                } else {
                    datos.set(i, datos.get(i) + rowData.get(i));
                }
            }
        }
        List<String> datosString = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            datosString.add( "" + (datos.get(i) / tamanyoGrupo));
        }
        centroide = new Row(datosString);
        return centroide;
    }
}
