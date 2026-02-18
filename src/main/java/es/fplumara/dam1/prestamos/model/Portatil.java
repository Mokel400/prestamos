package es.fplumara.dam1.prestamos.model;

import java.util.Set;
import java.util.UUID;

public class Portatil extends Material{

    private int ramGB;


    public Portatil(String id, String nombre, EstadoMaterial estado, Set<String> etiquetas) {
        super(id, nombre, estado, etiquetas);
    }

    public Portatil(String id, String nombre, EstadoMaterial estado, Set<String> etiquetas, int ramGB) {
        super(id, nombre, estado, etiquetas);
        this.ramGB = ramGB;
    }

    @Override
    public String getTipo() {
        return "Portatil";
    }


    public String toString() {
        return "Portatil{" +
                "id='" + getId() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", estado=" + getEstado() +
                ", etiquetas=" + getEtiquetas() +
                ", ramGB= " + ramGB +
                '}';
    }

    public int getExtra() {
        return ramGB;
    }

}
