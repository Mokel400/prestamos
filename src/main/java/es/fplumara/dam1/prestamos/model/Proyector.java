package es.fplumara.dam1.prestamos.model;

import java.util.Set;
import java.util.UUID;

public class Proyector extends Material{

    private int lumens;

    public Proyector(UUID id, String nombre, EstadoMaterial estado, Set<String> etiquetas) {
        super(id, nombre, estado, etiquetas);
    }

    public Proyector(UUID id, String nombre, EstadoMaterial estado, Set<String> etiquetas, int lumens) {
        super(id, nombre, estado, etiquetas);
        this.lumens = lumens;
    }

    @Override
    public String getTipo() {
        return null;
    }
}
