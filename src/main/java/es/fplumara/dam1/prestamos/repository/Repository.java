package es.fplumara.dam1.prestamos.repository;

import es.fplumara.dam1.prestamos.model.Identificable;
import es.fplumara.dam1.prestamos.model.Material;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Repository <T extends Identificable>{

    public void save(T elemento);
    public Optional<T> findById(String id);
    public List<T> listAll();
    public void delete(String id);
}
