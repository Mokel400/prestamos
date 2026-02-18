package es.fplumara.dam1.prestamos.model;

import java.util.Set;

public class Proyector extends Material{

    private Integer lumens;

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

    public Integer getExtra() {
        return lumens;
    }

}
