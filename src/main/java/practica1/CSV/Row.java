package practica1.CSV;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Row {
    List<Double> data;

    public Row(List<String> linea){
        creaFila(linea);
    }

    public Row() {
    }

    protected void creaFila (List<String> linea){
        data = new ArrayList<>();
        for(String elemento: linea){
            data.add(new Double(elemento));
        }
    }


    public List<Double> getData() {
        return data;
    }
}
