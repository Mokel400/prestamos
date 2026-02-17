package es.fplumara.dam1.prestamos.model;

import java.time.LocalDate;
import java.util.UUID;

public class Prestamo implements Identificable {

    private UUID id;
    private UUID idMaterial;
    private String Profesor;
    private LocalDate fecha;


    public Prestamo(UUID id, UUID idMaterial, String profesor, LocalDate fecha) {
        this.id = id;
        this.idMaterial = idMaterial;
        Profesor = profesor;
        this.fecha = fecha;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(UUID idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getProfesor() {
        return Profesor;
    }

    public void setProfesor(String profesor) {
        Profesor = profesor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
