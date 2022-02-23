package practica1.RegresionLineal;

import practica1.CSV.Table;

import java.lang.Math;
import java.util.List;

public class RegresionLineal {
    Double alpha, beta;

    public RegresionLineal() {
    }

    public void train(Table data) {
        Double mediaX, mediaY;
        double sumaX = 0.0, sumaY = 0.0, sumaNumerador = 0.0, sumaDenominador = 0.0;

        List<Double> x = data.getColumAt(0);
        List<Double> y = data.getColumAt(1);

        for (int i = 0; i < data.size(); i++) {
            sumaX += x.get(i);
            sumaY += y.get(i);
        }
        mediaX = sumaX / data.size();
        mediaY = sumaY / data.size();

        for (int i = 0; i < data.size(); i++) {
            sumaNumerador += (x.get(i) - mediaX) * (y.get(i) - mediaY);
            sumaDenominador += Math.pow(x.get(i) - mediaX, 2);
        }
        alpha = sumaNumerador / sumaDenominador;
        beta = mediaY - alpha * mediaX;
    }

    public Double estimate(Double sample) {
        return alpha * sample + beta;
    }

    public Double getAlpha() {
        return alpha;
    }

    public Double getBeta() {
        return beta;
    }
}
