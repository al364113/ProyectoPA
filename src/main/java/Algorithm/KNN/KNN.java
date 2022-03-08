package Algorithm.KNN;

import CSV.RowWithLabel;
import CSV.TableWithLabels;
import java.lang.Math;
import java.util.List;

public class KNN {
    TableWithLabels data;

    public void train (TableWithLabels data) {
        this.data=data;
    }

    public String estimate (List<Double> sample) {
        String especie = null;
        double estimacion = -1.0, aux;

        for (int i =0; i< data.size(); i++){
            RowWithLabel r = data.getRowAt(i);
            aux = metricaEuclidea(sample,r.getData());
            if (estimacion < 0 || aux < estimacion) {
                estimacion = aux;
                especie = r.getLabel();
            }
        }

        return especie;
    }

    private double metricaEuclidea (List<Double> sample, List<Double> filaTabla) {
        double estimacion = 0.0;
        for (int i = 0; i< sample.size(); i++){
            estimacion += Math.pow(sample.get(i)- filaTabla.get(i),2);
        }
        return Math.sqrt(estimacion);
    }

}
