package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.model.EstadoMaterial;
import es.fplumara.dam1.prestamos.model.Portatil;
import es.fplumara.dam1.prestamos.model.Prestamo;
import es.fplumara.dam1.prestamos.repository.MaterialRepositoryImpl;
import es.fplumara.dam1.prestamos.repository.PrestamoRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;


class PrestamosServiceTest {

    // TODO (alumnos): añadir JUnit 5 y Mockito en el pom.xml y completar:
    //
    // - crearPrestamo_ok_cambiaEstado_y_guarda()
    // - crearPrestamo_materialNoExiste_lanzaNoEncontrado()
    // - crearPrestamo_materialNoDisponible_lanzaMaterialNoDisponible()
    // - devolverMaterial_ok_cambiaADisponible()
    //
    // Requisito: usar mocks de repositorios y verify(...)

    PrestamoService prestamoService;

    @BeforeEach
    void setup(){
        prestamoService = new PrestamoService();
        PrestamoRepositoryImpl prestamoRepository = mock(PrestamoRepositoryImpl.getInstance());
        when(prestamoRepository)
    }




    @Test
    void crearPrestamo_ok_cambiaEstado_y_guarda(){
        when(MaterialRepositoryImpl.getInstance().findById("M001")).thenReturn(Optional.of(new Portatil("M001", "Portátil Aula 1", EstadoMaterial.DISPONIBLE, Set.of("ofimática", "|aula1"), 16)));
        prestamoService.crearPrestamo("M001", "Mikel", LocalDate.now());
        verify(PrestamoRepositoryImpl.getInstance()).save(any());
    }







}
