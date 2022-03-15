package Algorithm.KNN;

import Algorithm.Algorithm;
import CSV.RowWithLabel;
import CSV.TableWithLabels;
import java.lang.Math;
import java.util.List;

public class KNN implements Algorithm<TableWithLabels,String,List<Double>> {
    TableWithLabels data;

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
            aux = metricaEuclidea(sample,r.getData());
            if (estimacion < 0 || aux < estimacion) {
                estimacion = aux;
                especie = r.getLabel();
            }
        }

        return especie;
    }

    public static double metricaEuclidea (List<Double> sample, List<Double> filaTabla) {
        double estimacion = 0.0;
        for (int i = 0; i< sample.size(); i++){
            estimacion += Math.pow(sample.get(i)- filaTabla.get(i),2);
        }
        return Math.sqrt(estimacion);
    }

}
