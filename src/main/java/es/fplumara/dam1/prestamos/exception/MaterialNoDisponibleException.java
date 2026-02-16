package es.fplumara.dam1.prestamos.exception;

public class MaterialNoDisponibleException extends RuntimeException {
    public MaterialNoDisponibleException(String message) {
        super("El material que esta buscando no esta disponible en este momento");
    }
}
