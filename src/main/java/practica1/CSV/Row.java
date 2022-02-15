package practica1.CSV;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Row {
    List<Double> data;

    public Row(List<String> linea){
        ListIterator<String> ite = linea.listIterator();
        while (ite.hasNext()){
            data.add(new Double(ite.next()));
        }
    }

    public Row() {
    }

    public List<Double> getData() {
        return data;
    }
}
