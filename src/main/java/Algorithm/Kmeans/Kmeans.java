package Algorithm.Kmeans;

import Algorithm.Algorithm;
import CSV.Row;
import CSV.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Algorithm.KNN.KNN;

public class Kmeans implements Algorithm<Table, String, Row> {
    int numberClusters;
    int iteractions;
    long seed;
    List<List<Row>> grupos;
    List<Row> centroides;

    public Kmeans() {
    }

    public Kmeans(int numberClusters, int iteractions, long seed) {
        this.numberClusters = numberClusters;
        this.iteractions = iteractions;
        this.seed = seed;
        grupos = new ArrayList<List<Row>>();
        centroides = new ArrayList<Row>();
    }

    @Override
    public void train(Table tabla) {

        Random random = new Random(seed);


        for (int i = 0; i < numberClusters; i++) {
            int n = random.nextInt();
            if (n<0) {
                n*=-1;
            }
            if (n>= tabla.size()) {
                n %= tabla.size();
            }
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
        int grupo = 0;
        double mejorDistancia = KNN.metricaEuclidea(r.getData(), centroides.get(0).getData());
        for (int i = 1; i < centroides.size(); i++) {
            double distancia = KNN.metricaEuclidea(r.getData(), centroides.get(i).getData());
            if (distancia < mejorDistancia) {
                mejorDistancia = distancia;
                grupo = i;
            }

        }
        return "cluster-" + grupo;
    }

    private void agrupa(Table tabla) {
        for (Row row : tabla.getRows()) {

            double mejorDistancia = KNN.metricaEuclidea(row.getData(), centroides.get(0).getData());
            int grupo = 0;
            for (int i = 1; i < centroides.size(); i++) {
                double distancia = KNN.metricaEuclidea(row.getData(), centroides.get(i).getData());
                if (distancia < mejorDistancia) {
                    mejorDistancia = distancia;
                    grupo = i;
                }
            }
            grupos.get(grupo).add(row);

        }
    }

    private void recalculaCentroides() {
        for (int i = 0; i < centroides.size(); i++) {
            centroides.set(i, formulaCentroide(grupos.get(i)));
        }
    }

    private Row formulaCentroide(List<Row> grupo) {
        Row centroide;
        int tamanyoGrupo = grupo.size();
        List<Double> datos = new ArrayList<>(); //¿Inicializar a 0?
        for (Row row : grupo) {
            //Bucle para recorrer getData
            List<Double> rowData = row.getData();
            for (int i = 0; i < rowData.size(); i++) { //¿Size -1 (etiquetas)?
                if (datos.size()<rowData.size()) {
                    datos.add(rowData.get(i));
                } else {
                    datos.set(i, datos.get(i) + rowData.get(i));
                }
            }
        }
        List<String> datosString = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            datosString.set(i, "" + (datos.get(i) / tamanyoGrupo));
        }
        centroide = new Row(datosString);
        return centroide;
    }
}
