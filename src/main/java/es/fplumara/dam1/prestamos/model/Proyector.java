package es.fplumara.dam1.prestamos.model;

import java.util.Set;
import java.util.UUID;

public class Proyector extends Material{

    private int lumens;

    public Proyector(String id, String nombre, EstadoMaterial estado, Set<String> etiquetas) {
        super(id, nombre, estado, etiquetas);
    }

    public Proyector(String id, String nombre, EstadoMaterial estado, Set<String> etiquetas, int lumens) {
        super(id, nombre, estado, etiquetas);
        this.lumens = lumens;
    }

    @Override
    public String getTipo() {
        return "Proyector";
    }

    public String toString() {
        return "Portatil{" +
                "id='" + getId() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", estado=" + getEstado() +
                ", etiquetas=" + getEtiquetas() +
                ", lumens= " + lumens +
                '}';
    }

    public int getExtra() {
        return lumens;
    }

}
