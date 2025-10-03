package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    @Test
    public void testNombreInvalido() {
        // Intentar crear un empleado con nombre inválido (contiene números)
        EmpleadoPermanente emp = new EmpleadoPermanente(1, "1234", 1500);

        // Como el nombre es inválido, el atributo nombre no se asigna
        assertNull(emp.getNombre(), "El nombre debería ser nulo al ser inválido");
    }

    @Test
    public void testSalarioInvalido() {
        // Intentar crear un empleado con salario inválido
        EmpleadoPermanente emp = new EmpleadoPermanente(2, "Juan", -500);

        // Como el salario es inválido, no debería asignarse
        assertEquals(0.0, emp.getSalarioMensual(), "El salario debería quedar en 0.0 cuando es inválido");
    }

    @Test
    public void testEmpleadoValido() {
        // Crear empleado con datos correctos
        EmpleadoPermanente emp = new EmpleadoPermanente(3, "Ana", 2500);

        // Validar que los datos sí se asignan
        assertEquals("Ana", emp.getNombre());
        assertEquals(2500, emp.getSalarioMensual());
    }
}
