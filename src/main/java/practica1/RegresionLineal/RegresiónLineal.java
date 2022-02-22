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
        Double mediaX, mediaY;
        double sumaX = 0.0, sumaY = 0.0, sumaNumerador = 0, sumaDenominador = 0;

        List<Double> x = data.getColumAt(0);
        List<Double> y = data.getColumAt(1);

        for (int i = 0; i < data.size(); i++) {
            sumaX = x.get(i);
            sumaY = y.get(i);
        }

        /*List<Double> d;
        for (Row fila : data.getRows()) {
            d = fila.getData();
            sumaX += d.get(0);
            sumaY += d.get(1);
        }*/
        mediaX = sumaX / x.size();
        mediaY = sumaY / y.size();

        /*List<Double> x = data.getColumAt(0);
        List<Double> y = data.getColumAt(1);*/

        for (int i = 0; i < data.size(); i++) {
            sumaNumerador += (x.get(i) - mediaX) * (y.get(i) - mediaY);
            sumaDenominador += Math.pow(x.get(i) - mediaX, 2);
        }
        alpha = sumaNumerador / sumaDenominador;
    }

    public Double estimate(Double sample) {
        return 0.0;
    }
}
