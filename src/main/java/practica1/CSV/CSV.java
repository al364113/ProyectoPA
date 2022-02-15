package practica1.CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    public static Table readTable(String nombreFichero) throws IOException {
        BufferedReader br = null;
        List<Double> fila;
        List<List<Double>> filas = new ArrayList<>();
        Table tabla = new Table();

        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String line = br.readLine();

            List<String> cabeceras = new ArrayList<>();
            for(String cabecera: line.split(" ")){
                cabeceras.add(cabecera);
            }

            while(line != null){
                fila = new ArrayList<>();
                for(String campo: line.split(" ")){
                    Double campoDouble = new Double(campo);
                    fila.add(campoDouble);
                }
                filas.add(fila);
                br.readLine();
            }
            tabla = new Table(cabeceras, filas);


        }catch (Exception e){
            System.out.println("Fallo al leer el fichero.");
        } finally {
            if(br != null){
                br.close();
            }
        }

        return tabla;
    }
}
