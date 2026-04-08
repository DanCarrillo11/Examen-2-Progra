package logicaNegocio;

import accesoDatos.UsuarioDAO;
import entidades.Usuario;
import java.util.*;

public class UsuarioService {
    private UsuarioDAO dao = new UsuarioDAO();

    public boolean registrarUsuario(String id, String nombre, String rol) throws Exception {
        if (id.isEmpty() || nombre.isEmpty() || rol.isEmpty()) {
            throw new Exception("Datos incompletos");
        }

        for (Usuario u : dao.obtenerUsuarios()) {
            if (u.getId().equals(id)) {
                throw new Exception("ID duplicado");
            }
        }

        dao.guardarUsuario(new Usuario(id, nombre, rol));
        return true;
    }

    public List<Usuario> listarUsuarios() throws Exception {
        return dao.obtenerUsuarios();
    }

    public void eliminarUsuario(String id) throws Exception {
        dao.eliminarUsuario(id);
    }
}