package practica1.CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSV {
    public String readTable() throws IOException {
        BufferedReader br = null;
        String nombreFichero = leeNombreFichero();
        List<String> filas = new ArrayList<String>();

        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String line = br.readLine();
            while(line != null){
                filas.add(line);
                br.readLine();
            }
            Table tabla = new Table(filas);
            return tabla;


        }catch (Exception e){
            System.out.println("Fallo al leer el fichero.");
        } finally {
            if(br != null){
                br.close();
            }
        }
    }

    private static String leeNombreFichero(){
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        return nombre;
    }
}
