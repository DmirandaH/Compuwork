package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DepartamentoTest {

    @Test
    public void testNombreInvalido() {
        Departamento depto = new Departamento(1, "1234");
        assertNull(depto.getNombre(), "El nombre debería ser nulo si es inválido");
    }

    @Test
    public void testAgregarEmpleadoNull() {
        Departamento depto = new Departamento(2, "Sistemas");
        depto.agregarEmpleado(null);
        assertTrue(depto.getEmpleados().isEmpty(), "No debería agregarse un empleado nulo");
    }

    @Test
    public void testDepartamentoValido() {
        Departamento depto = new Departamento(3, "Recursos Humanos");
        assertEquals("Recursos Humanos", depto.getNombre());
        assertEquals(3, depto.getId());
    }
}
