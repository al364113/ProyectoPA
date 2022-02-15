package practica1.CSV;

import java.util.ArrayList;
import java.util.List;

public class Row {
    List<Double> data;

    public Row(List<Double> linea){
        this.data = linea;
    }

    public List<Double> getData() {
        return data;
    }
}
