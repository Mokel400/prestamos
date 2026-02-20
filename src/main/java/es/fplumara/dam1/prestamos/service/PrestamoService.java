package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.exception.MaterialNoDisponibleException;
import es.fplumara.dam1.prestamos.exception.NoEncontradoException;
import es.fplumara.dam1.prestamos.model.EstadoMaterial;
import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.model.Prestamo;
import es.fplumara.dam1.prestamos.repository.BaseRepositoryImpl;
import es.fplumara.dam1.prestamos.repository.MaterialRepositoryImpl;
import es.fplumara.dam1.prestamos.repository.PrestamoRepositoryImpl;
import es.fplumara.dam1.prestamos.repository.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class PrestamoService extends BaseRepositoryImpl<Prestamo> {


    public PrestamoService(){}

    public PrestamoService(MaterialRepositoryImpl materialRepository, PrestamoRepositoryImpl prestamoRepository) {
    }

    public Prestamo crearPrestamo (String idMaterial, String profesor, LocalDate fecha){
        Optional<Material> mat = PrestamoRepositoryImpl.getInstance().findById(idMaterial);

        if (idMaterial == null | profesor == null | fecha == null){
            throw new IllegalArgumentException("Faltan datos");
        } else if (BaseRepositoryImpl.getInstance().findById(idMaterial).isEmpty()){
            throw new NoEncontradoException("El material buscado no existe");
        } else if (!mat.get().getEstado().equals(EstadoMaterial.DISPONIBLE)){
            throw new MaterialNoDisponibleException("El material solicitado no esta disponible");
        } else {
            Prestamo pres = new Prestamo (UUID.randomUUID().toString(), idMaterial, profesor, LocalDate.now());
            PrestamoRepositoryImpl.getInstance().save(pres);
            mat.get().setEstado(EstadoMaterial.PRESTADO);
            return pres;
        }
    }

    public void devolverMaterial (String idMaterial){
        Optional<Material> mat = PrestamoRepositoryImpl.getInstance().findById(idMaterial);
        if (idMaterial == null){
            throw new IllegalArgumentException("Faltan datos");
        }
        if (mat.isEmpty()){
            throw new NoEncontradoException("El material buscado no existe");
        }
        if (!mat.get().getEstado().equals(EstadoMaterial.PRESTADO)){
            throw new MaterialNoDisponibleException("El material no esta disponible para esta operación");
        }
        mat.get().setEstado(EstadoMaterial.DISPONIBLE);
        PrestamoRepositoryImpl.getInstance().save(mat.get());
        PrestamoRepositoryImpl.getInstance().listAll();
    }






}