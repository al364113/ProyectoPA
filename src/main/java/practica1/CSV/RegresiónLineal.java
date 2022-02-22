package practica1.CSV;
import java.lang.Math;
import java.util.List;

public class RegresiónLineal {
    Double alpha,beta;

    public RegresiónLineal(){}

    public void train(Table data){
        Double x_media,y_media,sum_numerador,sum_denominador;
        double aux_x=0.0, aux_y=0.0;

        for (Row i : data.getRows()) {
            List<Double> d = i.getData();
            aux_x += d.get(0);
            aux_y += d.get(1);
        }
        x_media=aux_x/data.size();
        y_media=aux_y/data.size();

        for (int i=1; i< data.size();i++){

        }
    }
    public Double estimate(Double sample){
        return 0.0;
    }
}
