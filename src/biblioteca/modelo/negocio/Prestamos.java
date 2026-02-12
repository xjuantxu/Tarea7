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

    /**
     * Realiza un préstamo.
     * @param libro Libro a prestar.
     * @param usuario Usuario que realiza el préstamo.
     * @param fecha Fecha del préstamo.
     * @return El préstamo creado o null si no se puede realizar.
     */
    public Prestamo prestar(Libro libro, Usuario usuario, LocalDate fecha) {

        if (libro == null || usuario == null || fecha == null) {
            return null;
        }

        Prestamo nuevo = new Prestamo(libro, usuario, fecha);
        prestamos.add(new Prestamo(nuevo)); // copia profunda

        return nuevo;
    }

    /**
     * Registra la devolución de un préstamo.
     * @param libro Libro devuelto.
     * @param usuario Usuario que devuelve el libro.
     * @param fecha Fecha de devolución.
     * @return true si se realizó correctamente.
     */
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

    /**
     * Devuelve todos los préstamos.
     * @return Array de copias profundas de los préstamos.
     */
    public Prestamo[] todos() {

        Prestamo[] resultado = new Prestamo[prestamos.size()];

        for (int i = 0; i < prestamos.size(); i++) {
            resultado[i] = new Prestamo(prestamos.get(i));
        }

        return resultado;
    }

    /**
     * Devuelve los préstamos de un usuario concreto.
     * @param usuario Usuario a consultar.
     * @return Array de préstamos del usuario.
     */
    public Prestamo[] todos(Usuario usuario) {

        if (usuario == null) {
            return new Prestamo[0];
        }

        List<Prestamo> filtrados = new ArrayList<>();

        for (Prestamo p : prestamos) {
            if (p.getUsuario().equals(usuario)) {
                filtrados.add(new Prestamo(p));
            }
        }

        return filtrados.toArray(new Prestamo[0]);
    }
}