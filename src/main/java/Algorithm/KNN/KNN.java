package Algorithm.KNN;

import Algorithm.Algorithm;
import Algorithm.distance.Distance;
import Algorithm.distance.DistanceClient;
import CSV.RowWithLabel;
import CSV.TableWithLabels;
import java.lang.Math;
import java.util.List;

public class KNN implements Algorithm<TableWithLabels,String,List<Double>>, DistanceClient {
    TableWithLabels data;
    Distance distance;


    public KNN(Distance distance){
        this.distance = distance;
    }

    @Override
    public void train (TableWithLabels data) {
        this.data=data;
    }

    @Override
    public String estimate (List<Double> sample) {
        String especie = null;
        double estimacion = -1.0, aux;

        for (int i =0; i< data.size(); i++){
            RowWithLabel r = data.getRowAt(i);
            aux = distance.calculateDistance(sample,r.getData());
            if (estimacion < 0 || aux < estimacion) {
                estimacion = aux;
                especie = r.getLabel();
            }
        }

        return especie;
    }

    @Override
    public void setDistance(Distance distance) {
        this.distance = distance;
    }
}
