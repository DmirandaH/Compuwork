/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Representa a un empleado temporal.
 * Se valida que las horas de contrato sean positivas.
 */
public class EmpleadoTemporal extends Empleado {
    private int horasContrato;

    public EmpleadoTemporal(int id, String nombre, int horasContrato) {
        super(id, nombre, "Temporal");
        try {
            setHorasContrato(horasContrato);
        } catch (Exception e) {
            System.out.println("⚠️ Error al asignar horas de contrato: " + e.getMessage());
        }
    }

    @Override
    public ReporteDesempeno calcularDesempeno() {
        return new ReporteDesempeno(this, 7.5, "Buen rendimiento en tareas asignadas.");
    }

    public int getHorasContrato() { return horasContrato; }

    public void setHorasContrato(int horasContrato) {
        if (horasContrato <= 0) {
            throw new IllegalArgumentException("Las horas de contrato deben ser mayores que 0.");
        }
        this.horasContrato = horasContrato;
    }
}
