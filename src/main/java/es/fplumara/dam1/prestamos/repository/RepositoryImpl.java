package es.fplumara.dam1.prestamos.repository;

import es.fplumara.dam1.prestamos.model.Identificable;

import java.util.*;

public class RepositoryImpl <T extends Identificable> implements Repository<T>{


    private static RepositoryImpl instance;
    private RepositoryImpl(){}
    public static RepositoryImpl getInstance(){
        if (instance == null){
            instance = new RepositoryImpl();
        }
        return instance;
    }


    Map<String, T> datos = new HashMap<>();
    List<T> datosLista = datos.values().stream().toList();

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
        return datosLista;
    }

    @Override
    public void delete(String id) {
        datos.remove(id);
    }
}
