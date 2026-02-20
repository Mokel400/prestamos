package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.model.EstadoMaterial;
import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.model.Portatil;
import es.fplumara.dam1.prestamos.model.Prestamo;
import es.fplumara.dam1.prestamos.repository.BaseRepositoryImpl;
import es.fplumara.dam1.prestamos.repository.MaterialRepositoryImpl;
import es.fplumara.dam1.prestamos.repository.PrestamoRepositoryImpl;
import es.fplumara.dam1.prestamos.repository.Repository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class PrestamosServiceTest {

    // TODO (alumnos): añadir JUnit 5 y Mockito en el pom.xml y completar:
    //
    // - crearPrestamo_ok_cambiaEstado_y_guarda()
    // - crearPrestamo_materialNoExiste_lanzaNoEncontrado()
    // - crearPrestamo_materialNoDisponible_lanzaMaterialNoDisponible()
    // - devolverMaterial_ok_cambiaADisponible()
    //
    // Requisito: usar mocks de repositorios y verify(...)




    @Mock
    public MockedStatic<PrestamoRepositoryImpl> prestamoRepositoryStatic = mockStatic(PrestamoRepositoryImpl.class);
    @Mock
    public MockedStatic<MaterialRepositoryImpl> materialRepositoryStatic = mockStatic(MaterialRepositoryImpl.class);




    private PrestamoService prestamoService;
    @BeforeEach
    //Esto se utiliza para mockear una clase con un singleton
    void setUp(){
        prestamoService = new PrestamoService();
    }



    @Test
    void crearPrestamo_ok_cambiaEstado_y_guarda(){
        Portatil nuevoPort = new Portatil("0001", "Portatil 1000", EstadoMaterial.DISPONIBLE, new HashSet<>(), 16);
        when(materialRepositoryStatic.findById("0001")).thenReturn(Optional.of(nuevoPort));
        prestamoService.crearPrestamo("0001", "Mikel", LocalDate.now());
        verify(PrestamoRepositoryImpl.getInstance()).save(any());
        assertEquals(EstadoMaterial.PRESTADO, nuevoPort.getEstado());
        materialRepositoryStatic.when()
    }







}
