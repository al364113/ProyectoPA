package practica1.CSV;

import java.util.List;

public class RowWithLabel extends Row {

    String label;

    public RowWithLabel(List<String> linea, String label) {
        super(linea);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
