package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTemporalTest {

    @Test
    public void testHorasInvalidas() {
        EmpleadoTemporal emp = new EmpleadoTemporal(1, "Pedro", -10);
        assertEquals(0, emp.getHorasContrato(), "Las horas deberían ser 0 si son inválidas");
    }

    @Test
    public void testNombreInvalido() {
        EmpleadoTemporal emp = new EmpleadoTemporal(2, "4567", 20);
        assertNull(emp.getNombre(), "El nombre debería ser nulo si es inválido");
    }

    @Test
    public void testEmpleadoValido() {
        EmpleadoTemporal emp = new EmpleadoTemporal(3, "Laura", 40);
        assertEquals("Laura", emp.getNombre());
        assertEquals(40, emp.getHorasContrato());
    }
}
