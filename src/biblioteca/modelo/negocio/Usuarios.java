package biblioteca.modelo.negocio;

import biblioteca.modelo.dominio.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
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

    public void alta(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }

        usuarios.add(new Usuario(usuario)); // copia profunda
    }


    public boolean baja(Usuario usuario) {
        if (usuario == null)
            return false;

        Iterator<Usuario> it = usuarios.iterator();

        while (it.hasNext()) {
            Usuario u = it.next();
            if (u.equals(usuario)) {
                it.remove();
                return true;
            }
        }

        return false;
    }


    public Usuario buscar(Usuario usuario) {
        if (usuario == null)
            return null;

        for (Usuario u : usuarios) {
            if (u.equals(usuario)) {
                return new Usuario(u);
            }
        }

        return null;
    }

    public List<Usuario> todos() {
        List<Usuario> copia = new ArrayList<>();

        for (Usuario u : usuarios) {
            copia.add(new Usuario(u));
        }

        return copia;
    }
}