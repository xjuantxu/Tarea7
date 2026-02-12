package biblioteca.modelo.negocio;

import biblioteca.modelo.dominio.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Usuarios (paquete negocio).
 * Gestiona la colección de usuarios de la biblioteca.
 * Permite alta, baja, búsqueda y listado de usuarios.
 * Utiliza ArrayList para almacenar dinámicamente los usuarios.
 */
public class Usuarios {

    // Atributo
    private List<Usuario> usuarios;

    // Constructor
    public Usuarios() {
        usuarios = new ArrayList<>();
    }

    /**
     * Alta de un usuario.
     * @param usuario Usuario a insertar.
     */
    public void alta(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }

        usuarios.add(new Usuario(usuario)); // copia profunda
    }

    /**
     * Baja de un usuario.
     * @param usuario Usuario a eliminar.
     * @return true si se eliminó, false en caso contrario.
     */
    public boolean baja(Usuario usuario) {
        if (usuario == null) {
            return false;
        }

        for (Usuario u : usuarios) {
            if (u.equals(usuario)) {
                usuarios.remove(u);
                return true;
            }
        }

        return false;
    }

    /**
     * Búsqueda de un usuario.
     * @param usuario Usuario a buscar.
     * @return Copia profunda del usuario si existe, null en caso contrario.
     */
    public Usuario buscar(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        for (Usuario u : usuarios) {
            if (u.equals(usuario)) {
                return new Usuario(u); // copia profunda
            }
        }

        return null;
    }

    /**
     * Devuelve todos los usuarios.
     * @return Array de copias profundas de los usuarios.
     */
    public Usuario[] todos() {
        Usuario[] resultado = new Usuario[usuarios.size()];

        for (int i = 0; i < usuarios.size(); i++) {
            resultado[i] = new Usuario(usuarios.get(i)); // copia profunda
        }

        return resultado;
    }
}