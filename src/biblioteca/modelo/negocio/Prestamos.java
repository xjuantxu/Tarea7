package biblioteca.modelo.negocio;

import biblioteca.modelo.dominio.Prestamo;
import biblioteca.modelo.dominio.Libro;
import biblioteca.modelo.dominio.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Préstamos (paquete negocio).
 * Gestiona la colección de préstamos de la biblioteca.
 * Permite realizar préstamos, devoluciones y listados.
 * Utiliza ArrayList para almacenamiento dinámico.
 */
public class Prestamos {

    // Atributo
    private List<Prestamo> prestamos;

    // Constructor
    public Prestamos() {
        prestamos = new ArrayList<>();
    }

    public Prestamo prestar(Libro libro, Usuario usuario, LocalDate fecha) {

        if (libro == null || usuario == null || fecha == null) {
            return null;
        }

        Prestamo nuevo = new Prestamo(libro, usuario, fecha);
        prestamos.add(new Prestamo(nuevo)); // copia profunda

        return nuevo;
    }

    public boolean devolver(Libro libro, Usuario usuario, LocalDate fecha) {

        for (Prestamo p : prestamos) {
            if (p.getLibro().equals(libro)
                    && p.getUsuario().equals(usuario)
                    && !p.isDevuelto()) {

                p.devolver(fecha);
                return true;
            }
        }

        return false;
    }

    public List<Prestamo> todos() {

        List<Prestamo> copia = new ArrayList<>();

        for (Prestamo p : prestamos) {
            copia.add(new Prestamo(p));
        }

        return copia;
    }

    public List<Prestamo> todos(Usuario usuario) {

        List<Prestamo> copia = new ArrayList<>();

        if (usuario == null)
            return copia;

        for (Prestamo p : prestamos) {
            if (p.getUsuario().equals(usuario)) {
                copia.add(new Prestamo(p));
            }
        }

        return copia;
    }
}