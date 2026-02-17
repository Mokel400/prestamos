package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.exception.DuplicadoException;
import es.fplumara.dam1.prestamos.exception.NoEncontradoException;
import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.repository.BaseRepositoryImpl;

import java.util.List;

public class MaterialService extends BaseRepositoryImpl<Material> {


    public void registrarMaterial(Material m) {

        if (BaseRepositoryImpl.getInstance().listAll().contains(m.getId())) {
            throw new DuplicadoException("Material con ese id ya existe");
        }
        if ((m == null) || (m.getId() == null) || (m.getId().isBlank()) || (m.getId().isEmpty())) {
            throw new IllegalArgumentException("Faltan datos");
        }
        BaseRepositoryImpl.getInstance().save(m);
    }

    public void darDeBaja(String id){
        if (BaseRepositoryImpl.getInstance().findById(id) == null){
            throw new NoEncontradoException("El material que busca no existe");
        }
        BaseRepositoryImpl.getInstance().findById(id).
    }

    public List<Material> ListAll(){
      return BaseRepositoryImpl.getInstance().listAll();
    }




}