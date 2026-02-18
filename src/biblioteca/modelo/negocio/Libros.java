package biblioteca.modelo.negocio;

import biblioteca.modelo.dominio.Libro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase Libros (paquete negocio).
 * Gestiona la colección de libros de la biblioteca.
 * Permite alta, baja, búsqueda y listado de libros.
 * Utiliza ArrayList para almacenamiento dinámico.
 */
public class Libros {

    // Atributo
    private List<Libro> libros;

    // Constructor
    public Libros() {
        libros = new ArrayList<>();
    }


    public void alta(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }

        libros.add(new Libro(libro)); // copia profunda
    }

    public boolean baja(Libro libro) {
        if (libro == null) {
            return false;
        }

        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            Libro l = it.next();
            if (l.equals(libro)) {
                it.remove(); // forma 100% segura
                return true;
            }
        }

        return false;
    }

    public Libro buscar(Libro libro) {
        if (libro == null) {
            return null;
        }

        for (Libro l : libros) {
            if (l.equals(libro)) {
                return new Libro(l); // copia profunda
            }
        }

        return null;
    }

    public List<Libro> todos() {
        List<Libro> copia = new ArrayList<>();
        for (Libro l : libros) {
            copia.add(new Libro(l));
        }
        return copia;
    }
}