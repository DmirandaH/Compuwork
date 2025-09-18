/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 * Empleado permanente con salario mensual.
 */
public class EmpleadoPermanente extends Empleado {
    private double salarioMensual;

    public EmpleadoPermanente(int id, String nombre, double salarioMensual) {
        super(id, nombre, "Permanente");
        this.salarioMensual = salarioMensual;
    }

    /**
     * Aquí devolvemos un ReporteDesempeno simulado.
     * En un sistema real se calcularía con métricas reales.
     */
    @Override
    public ReporteDesempeno calcularDesempeno() {
        // ejemplo de puntuación fija + comentario
        double puntuacion = 9.0;
        String observaciones = "Desempeño estable y confiable.";
        return new ReporteDesempeno(this, puntuacion, observaciones);
    }

    public double getSalarioMensual() { return salarioMensual; }
}
