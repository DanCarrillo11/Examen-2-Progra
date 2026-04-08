package logicaNegocio;

import accesoDatos.AccesoDAO;
import entidades.Acceso;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccesoService {

    private AccesoDAO dao = new AccesoDAO();

    // 🔹 REGISTRAR ENTRADA
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

    // 🔹 REGISTRAR SALIDA
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

    // 🔹 HISTORIAL DE ACCESOS
    public List<Acceso> obtenerHistorial(String idUsuario) throws Exception {
        List<Acceso> accesos = dao.obtenerAccesos();
        List<Acceso> historial = new ArrayList<>();

        for (Acceso a : accesos) {
            if (a.getIdUsuario().equals(idUsuario)) {
                historial.add(a);
            }
        }

        if (historial.isEmpty()) {
            throw new Exception("No hay accesos para este usuario");
        }

        return historial;
    }

    // 🔹 TIEMPO TOTAL EN LABORATORIO (EN MINUTOS)
    public long calcularTiempoTotal(String idUsuario) throws Exception {
        List<Acceso> accesos = dao.obtenerAccesos();
        long totalMinutos = 0;

        for (Acceso a : accesos) {
            if (a.getIdUsuario().equals(idUsuario) && !a.getFechaSalida().equals("null")) {

                LocalDateTime entrada = LocalDateTime.parse(a.getFechaEntrada());
                LocalDateTime salida = LocalDateTime.parse(a.getFechaSalida());

                Duration duracion = Duration.between(entrada, salida);
                totalMinutos += duracion.toMinutes();
            }
        }

        return totalMinutos;
    }
}