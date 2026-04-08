package accesoDatos;

import entidades.Usuario;
import java.io.*;
import java.util.*;

public class UsuarioDAO {
    private final String archivo = "archivos/usuarios.txt";

    public void guardarUsuario(Usuario usuario) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
        bw.write(usuario.toString());
        bw.newLine();
        bw.close();
    }

    public List<Usuario> obtenerUsuarios() throws IOException {
        List<Usuario> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            lista.add(new Usuario(datos[0], datos[1], datos[2]));
        }
        br.close();
        return lista;
    }

    public void eliminarUsuario(String id) throws IOException {
        List<Usuario> lista = obtenerUsuarios();
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

        for (Usuario u : lista) {
            if (!u.getId().equals(id)) {
                bw.write(u.toString());
                bw.newLine();
            }
        }
        bw.close();
    }
}