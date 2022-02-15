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
        ListIterator<String> ite = linea.listIterator();
        while (ite.hasNext()){
            data.add(new Double(ite.next()));
        }
    }


    public List<Double> getData() {
        return data;
    }
}
