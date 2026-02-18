package es.fplumara.dam1.prestamos.repository;

import es.fplumara.dam1.prestamos.model.Identificable;

import java.util.*;

public class BaseRepositoryImpl<T extends Identificable> implements Repository<T>{


    private static BaseRepositoryImpl instance;
    public BaseRepositoryImpl(){}
    public static BaseRepositoryImpl getInstance(){
        if (instance == null){
            instance = new BaseRepositoryImpl();
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
        Optional<T> idEncontrado = Optional.ofNullable(datos.get(id));
        return idEncontrado;
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
