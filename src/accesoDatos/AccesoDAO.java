package accesoDatos;

import entidades.Acceso;
import java.io.*;
import java.util.*;

public class AccesoDAO {
    private final String archivo = "archivos/accesos.txt";

    public void guardarAcceso(Acceso acceso) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
        bw.write(acceso.toString());
        bw.newLine();
        bw.close();
    }

    public List<Acceso> obtenerAccesos() throws IOException {
        List<Acceso> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] d = linea.split(",");
            lista.add(new Acceso(d[0], d[1], d[2]));
        }
        br.close();
        return lista;
    }

    public void sobrescribir(List<Acceso> lista) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        for (Acceso a : lista) {
            bw.write(a.toString());
            bw.newLine();
        }
        bw.close();
    }
}