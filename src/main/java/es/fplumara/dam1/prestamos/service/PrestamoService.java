package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.exception.NoEncontradoException;
import es.fplumara.dam1.prestamos.model.Prestamo;
import es.fplumara.dam1.prestamos.repository.BaseRepositoryImpl;

import java.time.LocalDate;

public class PrestamoService extends BaseRepositoryImpl<Prestamo> {

    public void crearPrestamo (String idMaterial, String profesor, LocalDate fecha){
        if (idMaterial == null | profesor == null | fecha == null){
            throw new IllegalArgumentException("Faltan datos");
        }
        if (BaseRepositoryImpl.getInstance().findById(idMaterial).isEmpty()){
            throw new NoEncontradoException("El material buscado no existe");
        }
        if (BaseRepositoryImpl.getInstance().findById(idMaterial).g)
    }






}