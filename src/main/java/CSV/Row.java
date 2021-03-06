package CSV;

import java.util.ArrayList;
import java.util.List;

public class Row {
    List<Double> data;

    public Row() {
    }

    public Row(List<String> linea) {
        data = new ArrayList<>();
        for (String elemento : linea) {
            data.add(new Double(elemento));
        }
    }


    public List<Double> getData() {
        return data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
