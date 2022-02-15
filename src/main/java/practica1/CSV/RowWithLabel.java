package practica1.CSV;

import java.util.List;

public class RowWithLabel extends Row {

    String label;

    public RowWithLabel(List<String> linea) {
        label= linea.remove(linea.size()-1);
        super(linea);


    }
}
