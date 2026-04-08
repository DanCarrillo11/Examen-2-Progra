package logicaNegocio;

import accesoDatos.AccesoDAO;
import entidades.Acceso;
import java.time.LocalDateTime;
import java.util.*;

public class AccesoService {
    private AccesoDAO dao = new AccesoDAO();

    public void registrarEntrada(String idUsuario) throws Exception {
        List<Acceso> accesos = dao.obtenerAccesos();

        for (Acceso a : accesos) {
            if (a.getIdUsuario().equals(idUsuario) && a.getFechaSalida().equals("null")) {
                throw new Exception("Ya tiene una entrada activa");
            }
        }

        String ahora = LocalDateTime.now().toString();
        dao.guardarAcceso(new Acceso(idUsuario, ahora, "null"));
    }

    public void registrarSalida(String idUsuario) throws Exception {
        List<Acceso> accesos = dao.obtenerAccesos();
        boolean encontrado = false;

        for (Acceso a : accesos) {
            if (a.getIdUsuario().equals(idUsuario) && a.getFechaSalida().equals("null")) {
                a.setFechaSalida(LocalDateTime.now().toString());
                encontrado = true;
            }
        }

        if (!encontrado) {
            throw new Exception("No tiene entrada previa");
        }

        dao.sobrescribir(accesos);
    }
}