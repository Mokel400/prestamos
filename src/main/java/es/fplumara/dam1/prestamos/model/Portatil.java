package es.fplumara.dam1.prestamos.model;

import java.util.Set;
import java.util.UUID;

public class Portatil extends Material{

    private int ramGB;


    public Portatil(UUID id, String nombre, EstadoMaterial estado, Set<String> etiquetas) {
        super(id, nombre, estado, etiquetas);
    }

    public Portatil(UUID id, String nombre, EstadoMaterial estado, Set<String> etiquetas, int ramGB) {
        super(id, nombre, estado, etiquetas);
        this.ramGB = ramGB;
    }

    @Override
    public String getTipo() {
        return null;
    }
}
