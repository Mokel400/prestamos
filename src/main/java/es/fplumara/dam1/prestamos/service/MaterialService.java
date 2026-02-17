package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.exception.DuplicadoException;
import es.fplumara.dam1.prestamos.exception.MaterialNoDisponibleException;
import es.fplumara.dam1.prestamos.exception.NoEncontradoException;
import es.fplumara.dam1.prestamos.model.EstadoMaterial;
import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.repository.BaseRepositoryImpl;
import es.fplumara.dam1.prestamos.repository.MaterialRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class MaterialService extends BaseRepositoryImpl<Material> {


    public void registrarMaterial(Material m) {

        if (MaterialRepositoryImpl.getInstance().listAll().contains(m.getId())) {
            throw new DuplicadoException("Material con ese id ya existe");
        }
        if ((m == null) || (m.getId() == null) || (m.getId().isBlank()) || (m.getId().isEmpty())) {
            throw new IllegalArgumentException("Faltan datos");
        }
        BaseRepositoryImpl.getInstance().save(m);
    }

    public List<Material> darDeBaja(String id) {
        Optional<Material> mat = MaterialRepositoryImpl.getInstance().findById(id);

        if (MaterialRepositoryImpl.getInstance().findById(id) == null) {
            throw new NoEncontradoException("El material que busca no existe");
        }
        if (mat.get().getEstado().equals(EstadoMaterial.BAJA)) {
            throw new MaterialNoDisponibleException("El material ya esta dado de baja");
        }
        mat.get().setEstado(EstadoMaterial.BAJA);
        return MaterialRepositoryImpl.getInstance().listAll();
    }

    public List<Material> ListAll() {
        return BaseRepositoryImpl.getInstance().listAll();
    }


}