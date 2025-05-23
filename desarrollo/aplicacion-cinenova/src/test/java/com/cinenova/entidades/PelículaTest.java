package com.cinenova.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para las pruebas unitarias de la clase Película
 * 
 * @author Álvaro Muñoz
 */
@DisplayName("Pruebas unitarias para la clase Película")
public class PelículaTest {

    private Película pelicula;

    @BeforeEach
    @DisplayName("Inicialización del objeto Película para pruebas")
    public void setUp() {
        pelicula = new Película(1, "Inception", 148, "Ciencia ficción", "+13", "Una película sobre sueños dentro de sueños.");
    }

    @Test
    @DisplayName("Verifica que los atributos se asignen correctamente")
    public void testConstructorAndGetters() {
        assertEquals(1, pelicula.getIdPelicula());
        assertEquals("Inception", pelicula.getTitulo());
        assertEquals(148, pelicula.getDuracion());
        assertEquals("Ciencia ficción", pelicula.getGenero());
        assertEquals("+13", pelicula.getClasificacionEdad());
        assertEquals("Una película sobre sueños dentro de sueños.", pelicula.getDescripcion());
    }

    @Test
    @DisplayName("Actualiza correctamente todos los atributos")
    public void testSetters() {
        pelicula.setIdPelicula(1);
        pelicula.setTitulo("Interstellar");
        pelicula.setDuracion(169);
        pelicula.setGenero("Drama espacial");
        pelicula.setClasificacionEdad("+12");
        pelicula.setDescripcion("Exploración espacial y agujeros de gusano.");

        assertEquals(1, pelicula.getIdPelicula());
        assertEquals("Interstellar", pelicula.getTitulo());
        assertEquals(169, pelicula.getDuracion());
        assertEquals("Drama espacial", pelicula.getGenero());
        assertEquals("+12", pelicula.getClasificacionEdad());
        assertEquals("Exploración espacial y agujeros de gusano.", pelicula.getDescripcion());
    }
    
    @Test
    @DisplayName("Añade una película a la base de datos")
    public void testAñadirPeliculaBD() {
        Película nueva = new Película(0, "Matrix", 136, "Acción", "+16", "Un hacker descubre la verdad sobre su realidad.");
        boolean resultado = Película.añadirPelicula(nueva);
        assertTrue(resultado, "La película debería haberse añadido correctamente.");
    }

    @Test
    @DisplayName("Actualiza una película existente en la base de datos")
    public void testActualizarPeliculaBD() {
        Película modificada = new Película(1, "Inception 2", 150, "Ciencia ficción", "+13", "Secuela no oficial de Inception.");
        boolean resultado = Película.actualizarPelicula(modificada);
        assertTrue(resultado, "La película debería haberse actualizado correctamente.");
    }

    @Test
    @DisplayName("Devuelve la representación esperada del objeto Película")
    public void testToString() {
        String expected = "Película{titulo=Inception, duracion=148, genero=Ciencia ficción, clasificacionEdad=+13, descripcion=Una película sobre sueños dentro de sueños.}";
        assertEquals(expected, pelicula.toString());
    }
}
