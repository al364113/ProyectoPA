package practica1.CSV;

import java.io.IOException;

public class prueba {
    public static void main(String[] args) throws IOException {
        TableWithLabels table = CSV.readTableWithLabels("src/main/resources/iris.csv");

    }
}
