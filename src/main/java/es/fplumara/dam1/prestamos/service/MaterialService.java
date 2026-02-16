package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.exception.DuplicadoException;
import es.fplumara.dam1.prestamos.exception.MaterialNoDisponibleException;
import es.fplumara.dam1.prestamos.model.EstadoMaterial;
import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.repository.Repository;
import es.fplumara.dam1.prestamos.repository.RepositoryImpl;

public class MaterialService {


    public void registrarMaterial(Material m) {

        if (RepositoryImpl.getInstance().listAll().contains(m.getId())) {
            throw new DuplicadoException("Material con ese id ya existe");
        }
        if ((m == null) || (m.getId() == null) || (m.getId().isBlank()) || (m.getId().isEmpty())) {
            throw new IllegalArgumentException("Faltan datos");
        }
        RepositoryImpl.getInstance().save(m);
    }



}
