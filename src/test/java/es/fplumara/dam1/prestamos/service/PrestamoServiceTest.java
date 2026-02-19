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


    private MockedStatic<PrestamoRepositoryImpl> prestamoRepositoryStatic;
    private MockedStatic<MaterialRepositoryImpl> materialRepositoryStatic;
    private MockedStatic<BaseRepositoryImpl> baseRepositoryStatic;

    @Mock
    private PrestamoRepositoryImpl prestamoRepository;
    @Mock
    private MaterialRepositoryImpl materialRepository;
    @Mock
    private BaseRepositoryImpl baseRepostory;

    private PrestamoService prestamoService;
    @BeforeEach
    //Esto se utiliza para mockear una clase con un singleton
    void setUp(){
        prestamoService = new PrestamoService();

        baseRepositoryStatic = Mockito.mockStatic(BaseRepositoryImpl.class);
        baseRepositoryStatic.when(BaseRepositoryImpl::getInstance).thenReturn(baseRepostory);

    }

    @AfterEach
    void tearDown(){
        baseRepositoryStatic.close();
    }

    @Test
    void crearPrestamo_ok_cambiaEstado_y_guarda(){
        Portatil nuevoPort;

        when(materialRepository.findById("0001")).thenReturn(Optional.of(nuevoPort = new Portatil("0001", "Portatil 1000", EstadoMaterial.DISPONIBLE, new HashSet<>(), 16)));
        prestamoService.crearPrestamo("0001", "Mikel", LocalDate.now());
        verify(PrestamoRepositoryImpl.getInstance()).save(any());
        assertEquals(EstadoMaterial.PRESTADO, nuevoPort.getEstado());
        verify(materialRepository).save(nuevoPort);
    }







}
