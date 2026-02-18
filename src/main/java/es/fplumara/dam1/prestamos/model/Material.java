package es.fplumara.dam1.prestamos.model;

import java.util.Set;

public abstract class Material implements Identificable{


    private String id;
    private String nombre;
    private EstadoMaterial estado;
    private Set<String> etiquetas;


    public Material(String id, String nombre, EstadoMaterial estado, Set<String> etiquetas) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.etiquetas = etiquetas;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoMaterial getEstado() {
        return estado;
    }

    public Set<String> getEtiquetas() {
        return etiquetas;
    }

    public abstract String getTipo();

    public abstract Integer getExtra();

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(EstadoMaterial estado) {
        this.estado = estado;
    }

    public void setEtiquetas(Set<String> etiquetas) {
        this.etiquetas = etiquetas;
    }
}