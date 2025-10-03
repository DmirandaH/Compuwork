package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoPermanenteTest {

    @Test
    public void testNombreInvalido() {
        EmpleadoPermanente emp = new EmpleadoPermanente(1, "1234", 1500);
        assertNull(emp.getNombre(), "El nombre debería ser nulo si es inválido");
    }

    @Test
    public void testSalarioInvalido() {
        EmpleadoPermanente emp = new EmpleadoPermanente(2, "Juan", -500);
        assertEquals(0.0, emp.getSalarioMensual(), "El salario debería ser 0.0 si es inválido");
    }

    @Test
    public void testEmpleadoValido() {
        EmpleadoPermanente emp = new EmpleadoPermanente(3, "Carlos", 2000);
        assertEquals("Carlos", emp.getNombre());
        assertEquals(2000.0, emp.getSalarioMensual());
    }
}
