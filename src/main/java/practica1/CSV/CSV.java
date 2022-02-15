package practica1.CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    public static Table readTable(String nombreFichero,int tipo) throws IOException {
        BufferedReader br = null;
        List<String> fila;
        List<List<String>> filas = new ArrayList<>();
        Table tabla;
        if (tipo==0) tabla=new Table();
        else tabla=new TableWithLabels();

        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String line = br.readLine();

            while(line != null){
                fila = new ArrayList<>();
                for(String campo: line.split(" ")){
                    fila.add(campo);
                }
                filas.add(fila);
                br.readLine();
            }
            tabla = new Table(filas);


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
