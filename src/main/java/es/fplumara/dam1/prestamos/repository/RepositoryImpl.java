package es.fplumara.dam1.prestamos.repository;

import es.fplumara.dam1.prestamos.model.Identificable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RepositoryImpl <T extends Identificable> implements Repository<T>{

    Map<String, T> datos = new HashMap<>();

    @Override
    public void save(T elemento) {
        datos.put(elemento.getId(), elemento);
    }

    @Override
    public Optional<T> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    @Override
    public List<T> listAll() {
        return List.of((T) datos.values());
    }

    @Override
    public void delete(String id) {
        datos.remove(id);
    }
}
