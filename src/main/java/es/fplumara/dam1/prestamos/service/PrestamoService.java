package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.exception.NoEncontradoException;
import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.model.Prestamo;
import es.fplumara.dam1.prestamos.repository.RepositoryImpl;

import java.time.LocalDate;

public class PrestamoService extends RepositoryImpl<Prestamo> {

    public void crearPrestamo (String idMaterial, String profesor, LocalDate fecha){
        if (idMaterial == null | profesor == null | fecha == null){
            throw new IllegalArgumentException("Faltan datos");
        }
        if (RepositoryImpl.getInstance().findById(idMaterial).isEmpty()){
            throw new NoEncontradoException("El material buscado no existe");
        }
        if (RepositoryImpl.getInstance().findById(idMaterial).g)
    }






}