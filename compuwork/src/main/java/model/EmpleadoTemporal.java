/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Empleado temporal con horas de contrato.
 */
public class EmpleadoTemporal extends Empleado {
    private int horasContrato;

    public EmpleadoTemporal(int id, String nombre, int horasContrato) {
        super(id, nombre, "Temporal");
        this.horasContrato = horasContrato;
    }

    @Override
    public ReporteDesempeno calcularDesempeno() {
        double puntuacion = 7.5;
        String observaciones = "Buen rendimiento en tareas asignadas.";
        return new ReporteDesempeno(this, puntuacion, observaciones);
    }

    public int getHorasContrato() { return horasContrato; }
}
