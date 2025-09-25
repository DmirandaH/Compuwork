/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 * Clase que genera reportes de desempeño para empleados.
 * Se valida que el empleado no sea nulo y que la puntuación sea válida.
 */
public class ReporteDesempeno {
    private Empleado empleado;
    private LocalDate fecha;
    private double puntuacion;
    private String observaciones;

    public ReporteDesempeno(Empleado empleado, double puntuacion, String observaciones) {
        try {
            setEmpleado(empleado);
            setPuntuacion(puntuacion);
            this.fecha = LocalDate.now();
            this.observaciones = observaciones;
        } catch (Exception e) {
            System.out.println("⚠️ Error al generar reporte: " + e.getMessage());
        }
    }

    public String generarReporte() {
        return "📋 Reporte de " + empleado.getNombre() +
               " (" + puntuacion + " puntos): " + observaciones +
               " - Fecha: " + fecha;
    }

    // Getters y Setters con validación
    public Empleado getEmpleado() { return empleado; }
    public LocalDate getFecha() { return fecha; }
    public double getPuntuacion() { return puntuacion; }
    public String getObservaciones() { return observaciones; }

    public void setEmpleado(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo.");
        }
        this.empleado = empleado;
    }

    public void setPuntuacion(double puntuacion) {
        if (puntuacion < 0 || puntuacion > 10) {
            throw new IllegalArgumentException("La puntuación debe estar entre 0 y 10.");
        }
        this.puntuacion = puntuacion;
    }
}
