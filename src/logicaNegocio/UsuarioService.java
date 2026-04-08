package logicaNegocio;

import accesoDatos.UsuarioDAO;
import entidades.Usuario;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO dao = new UsuarioDAO();

    public boolean registrarUsuario(String id, String nombre, String rol) throws Exception {

        // 🔥 VALIDAR DATOS VACÍOS
        if (id == null || id.trim().isEmpty()) {
            throw new Exception("ID vacío");
        }

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Nombre vacío");
        }

        if (rol == null || rol.trim().isEmpty()) {
            throw new Exception("Rol vacío");
        }

        // 🔥 VALIDAR ROL
        if (!rol.equalsIgnoreCase("Estudiante") && !rol.equalsIgnoreCase("Docente")) {
            throw new Exception("Rol inválido");
        }

        // 🔥 VALIDAR ID DUPLICADO
        List<Usuario> usuarios = dao.obtenerUsuarios();
        for (Usuario u : usuarios) {
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