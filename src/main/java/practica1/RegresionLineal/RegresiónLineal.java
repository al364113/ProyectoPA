package practica1.RegresionLineal;

import practica1.CSV.Row;
import practica1.CSV.Table;

import java.lang.Math;
import java.util.List;

public class RegresiónLineal {
    Double alpha;
    Double beta;

    public RegresiónLineal() {
    }

    public void train(Table data) {
        Double x_media, y_media;
        double aux_x = 0.0, aux_y = 0.0, sum_numerador = 0, sum_denominador = 0;

        List<Double> x = data.getColumAt(0);
        List<Double> y = data.getColumAt(1);

        for(int i = 0; i < data.size(); i++){
            aux_x = x.get(i);
            aux_y = y.get(i);
        }

        /*List<Double> d;
        for (Row fila : data.getRows()) {
            d = fila.getData();
            aux_x += d.get(0);
            aux_y += d.get(1);
        }*/
        x_media = aux_x / data.size();
        y_media = aux_y / data.size();

        /*List<Double> x = data.getColumAt(0);
        List<Double> y = data.getColumAt(1);*/

        for (int i = 0; i < data.size(); i++) {
            sum_numerador += (x.get(i) - x_media) * (y.get(i) - y_media);
            sum_denominador += Math.pow(x.get(i) - x_media, 2);
        }
        alpha = sum_numerador / sum_denominador;
    }

    public Double estimate(Double sample) {
        return 0.0;
    }
}
