package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase ReporteDesempeno.
 * Adaptadas al manejo de errores con try-catch dentro de la clase.
 */
public class ReporteDesempenoTest {

    @Test
    public void testPuntuacionValida() {
        Empleado emp = new EmpleadoPermanente(1, "Carlos", 1500);
        ReporteDesempeno reporte = new ReporteDesempeno(emp, 8.5, "Buen desempeño");

        assertNotNull(reporte);
        assertEquals(8.5, reporte.getPuntuacion());
        assertEquals("Buen desempeño", reporte.getObservaciones());
        assertTrue(reporte.generarReporte().contains("Carlos"));
    }

    @Test
    public void testPuntuacionInvalida() {
        Empleado emp = new EmpleadoTemporal(2, "Ana", 40);

        // Se pasa puntuación inválida (-5). El try-catch de la clase lo evita.
        ReporteDesempeno reporte = new ReporteDesempeno(emp, -5, "Error en datos");

        // Como no se asigna la puntuación inválida, debería quedar en 0.0
        assertEquals(0.0, reporte.getPuntuacion(), "La puntuación inválida debería resetearse a 0.0");
    }

    @Test
    public void testEmpleadoNulo() {
        ReporteDesempeno reporte = new ReporteDesempeno(null, 7, "Empleado nulo");

        // Como el empleado era nulo, no debe asignarse
        assertNull(reporte.getEmpleado(), "El empleado no debería asignarse si es nulo");
    }
}
