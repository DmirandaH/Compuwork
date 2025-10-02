/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Representa a un empleado temporal.
 * Se valida la cantidad de horas contratadas.
 */
public class EmpleadoTemporal extends Empleado {
    private int horasContrato;

    /**
     * Constructor de EmpleadoTemporal.
     * @param id identificador único del empleado.
     * @param nombre nombre del empleado.
     * @param horasContrato cantidad de horas contratadas.
     */
    public EmpleadoTemporal(int id, String nombre, int horasContrato) {
        super(id, nombre, "Temporal");
        try {
            setHorasContrato(horasContrato);
        } catch (Exception e) {
            System.out.println("⚠️ Error al asignar horas de contrato: " + e.getMessage());
            this.horasContrato = 40; // valor por defecto (ejemplo)
        }
    }

    /**
     * Implementación de cálculo de desempeño para empleado temporal.
     * Retorna un reporte con una puntuación predefinida y descripción.
     */
    @Override
    public ReporteDesempeno calcularDesempeno() {
        return new ReporteDesempeno(this, 7.5, "Buen rendimiento en tareas asignadas.");
    }

    // Getter y Setter con validación
    public int getHorasContrato() { return horasContrato; }

    public void setHorasContrato(int horasContrato) {
        if (horasContrato <= 0) {
            throw new IllegalArgumentException("Las horas de contrato deben ser mayores que 0.");
        }
        this.horasContrato = horasContrato;
    }
}
