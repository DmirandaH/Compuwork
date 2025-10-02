/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 * Clase que genera reportes de desempeño para empleados.
 * Incluye validaciones en empleado, puntuación y observaciones.
 */
public class ReporteDesempeno {
    private Empleado empleado;
    private LocalDate fecha;
    private double puntuacion;
    private String observaciones;

    /**
     * Constructor del reporte con validaciones.
     * @param empleado Empleado asociado al reporte
     * @param puntuacion Puntuación entre 0 y 10
     * @param observaciones Texto descriptivo del desempeño
     */
    public ReporteDesempeno(Empleado empleado, double puntuacion, String observaciones) {
        try {
            setEmpleado(empleado);
            setPuntuacion(puntuacion);
            setObservaciones(observaciones);
            this.fecha = LocalDate.now();
        } catch (Exception e) {
            System.out.println("⚠️ Error al generar reporte: " + e.getMessage());
            this.fecha = LocalDate.now();
            this.puntuacion = 0;
            this.observaciones = "Reporte inválido.";
        }
    }

    /**
     * Genera un reporte en formato de texto.
     */
    public String generarReporte() {
        return "📋 Reporte de " + empleado.getNombre() +
               " (" + puntuacion + " puntos): " + observaciones +
               " - Fecha: " + fecha;
    }

    // ================== Getters ==================
    public Empleado getEmpleado() { return empleado; }
    public LocalDate getFecha() { return fecha; }
    public double getPuntuacion() { return puntuacion; }
    public String getObservaciones() { return observaciones; }

    // ================== Setters con validación ==================
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

    public void setObservaciones(String observaciones) {
        if (observaciones == null || observaciones.trim().isEmpty()) {
            throw new IllegalArgumentException("Las observaciones no pueden estar vacías.");
        }
        this.observaciones = observaciones.trim();
    }
}
