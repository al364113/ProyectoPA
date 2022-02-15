package practica1.CSV;

import java.util.List;

public class RowWithLabel extends Row {

    String label;

    public RowWithLabel(List<String> linea) {
        label = linea.get(linea.size()-1);
        super();
    }
}
