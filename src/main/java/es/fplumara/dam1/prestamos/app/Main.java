package es.fplumara.dam1.prestamos.app;

import es.fplumara.dam1.prestamos.csv.CSVMaterialExporter;
import es.fplumara.dam1.prestamos.csv.CSVMaterialImporter;
import es.fplumara.dam1.prestamos.csv.RegistroMaterialCsv;
import es.fplumara.dam1.prestamos.model.*;
import es.fplumara.dam1.prestamos.repository.MaterialRepositoryImpl;
import es.fplumara.dam1.prestamos.service.MaterialService;
import es.fplumara.dam1.prestamos.service.PrestamoService;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Main de ejemplo para demostrar el flujo mínimo del examen (sin menú complejo).
 * La idea es que este método ejecute una "demo" por consola.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Examen DAM1 - Préstamo de Material (Java 21)");

        MaterialService mat = new MaterialService();
        PrestamoService pres = new PrestamoService();

        CSVMaterialImporter importer  = new CSVMaterialImporter();
        CSVMaterialExporter exporter = new CSVMaterialExporter();
        Path pathEntradaMateriales = Path.of("data/materiales.csv");
        Path pathSalidaMateriales = Path.of("data/salidaMateriales.csv");

        List<RegistroMaterialCsv> registros = importer.leer(pathEntradaMateriales.toString());
        List<Portatil> portatiles = new ArrayList<>();
        List<Proyector> proyectores = new ArrayList<>();
        List<String> profesores = List.of("Mikel", "Hector", "Carmen", "Samuel", "Raúl");
        List<Prestamo> prestamos = new ArrayList<>();
        List<Material> materialesPrestados = new ArrayList<>();

        for (int i = 0; i < registros.size(); i++) {
            if (registros.get(i).tipo().equalsIgnoreCase("portatil")){
                Portatil portatil = new Portatil (registros.get(i).id(), registros.get(i).nombre(), EstadoMaterial.valueOf(registros.get(i).estado()), registros.get(i).etiquetas());
                mat.registrarMaterial(portatil);
                portatiles.add(portatil);
            } else if (registros.get(i).tipo().equalsIgnoreCase("proyector")){
                Proyector proyector = new Proyector(registros.get(i).id(), registros.get(i).nombre(), EstadoMaterial.valueOf(registros.get(i).estado()), registros.get(i).etiquetas());
                mat.registrarMaterial(proyector);
                proyectores.add(proyector);
            }
        }


        for (int i = 0; i < portatiles.size(); i++) {
            if (portatiles.get(i).getEstado().equals(EstadoMaterial.DISPONIBLE)){
                prestamos.add(pres.crearPrestamo(portatiles.get(i).getId(), profesores.get(i), LocalDate.now()));
                materialesPrestados.add(portatiles.get(i));
            }

        }
        for (int i = 0; i < proyectores.size(); i++) {
            if (proyectores.get(i).getEstado().equals(EstadoMaterial.DISPONIBLE)){
                prestamos.add(pres.crearPrestamo(proyectores.get(i).getId(), profesores.get(i), LocalDate.now()));
                materialesPrestados.add(proyectores.get(i));
            }
        }



        System.out.println("Prestamos");
        prestamos.stream().forEach(System.out::println);
        System.out.println("----------");

        System.out.println("Portatiles");
        portatiles.stream().forEach(System.out::println);
        System.out.println("----------");

        System.out.println("Proyectores");
        proyectores.stream().forEach(System.out::println);
        System.out.println("----------");

        System.out.println("Material devuelto");
        pres.devolverMaterial("M001");
        System.out.println(portatiles);


        List<RegistroMaterialCsv> registrosSalida = materialesPrestados.stream().map(material -> new RegistroMaterialCsv(material.getTipo(), material.getId(), material.getNombre(), material.getEstado().toString(), material.getExtra(), material.getEtiquetas())).toList();
        exporter.escribir(pathSalidaMateriales.toString(), registrosSalida);

        /*
         * FLUJO MÍNIMO OBLIGATORIO (lo que debe hacer tu main)
         *
         * 1) Crear repositorios en memoria
         *    - Crear MaterialRepositoryImpl (almacena materiales en memoria).
         *    - Crear PrestamoRepositoryImpl (almacena préstamos en memoria).
         *
         * 2) Crear servicios
         *    - Crear MaterialService usando el repositorio de materiales.
         *    - Crear PrestamoService usando el repositorio de materiales y el de préstamos.
         *
         * 3) Cargar materiales desde CSV (código proporcionado)
         *    - Usar CsvMaterialImporter para leer "materiales.csv".
         *    - El importer devuelve registros (por ejemplo RegistroMaterialCsv).
         *    - Convertir cada registro a tu modelo:
         *        - Si tipo == "PORTATIL" -> crear Portatil (extra = ramGB)
         *        - Si tipo == "PROYECTOR" -> crear Proyector (extra = lumens)
         *      (aplicando estado y etiquetas)
         *    - Registrar cada Material llamando a MaterialService.registrarMaterial(...)
         *
         * 4) Crear un préstamo
         *    - Elegir un id de material existente (por ejemplo "M001").
         *    - Llamar a PrestamoService.crearPrestamo("M001", "Nombre Profesor", fecha)
         *    - Comprobar que el material pasa a estado PRESTADO
         *
         * 5) Listar por consola
         *    - Imprimir todos los materiales (MaterialService.listar()) mostrando: id, nombre, estado, tipo.
         *    - Imprimir todos los préstamos (PrestamoService.listarPrestamos()) mostrando: id, idMaterial, profesor, fecha.
         *
         * 6) Devolver el material
         *    - Llamar a PrestamoService.devolverMaterial("M001")
         *    - Comprobar que vuelve a estado DISPONIBLE
         *
         * 7) Exportar a CSV (código proporcionado)
         *    - Convertir tu lista de Material a la estructura que pida el exporter (por ejemplo RegistroMaterialCsv).
         *    - Usar CsvMaterialExporter para escribir "salida_materiales.csv".
         *
         * Nota:
         * - No hace falta interfaz, ni menú, ni pedir datos por teclado: valores fijos y salida por consola es suficiente.
         */
    }
}