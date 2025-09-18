/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un reporte de desempeño para un empleado.
 * Nota: usamos nombres sin acentos para evitar problemas con encoding/identificadores.
 */
public class ReporteDesempeno {
    private Empleado empleado;
    private LocalDate fecha;
    private double puntuacion;
    private String observaciones;

    public ReporteDesempeno(Empleado empleado, double puntuacion, String observaciones) {
        if (empleado == null) {
            throw new IllegalArgumentException("Empleado no puede ser nulo.");
        }
        this.empleado = empleado;
        this.fecha = LocalDate.now();
        this.puntuacion = puntuacion;
        this.observaciones = observaciones;
    }

    /**
     * Genera una cadena con la información del reporte.
     * @return texto del reporte
     */
    public String generarReporte() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.format("Reporte (%s) - Empleado: %s (id=%d) - Puntuación: %.1f - Obs: %s",
                fecha.format(f), empleado.getNombre(), empleado.getId(), puntuacion, observaciones);
    }

    // Getters si se requieren
    public Empleado getEmpleado() { return empleado; }
    public LocalDate getFecha() { return fecha; }
    public double getPuntuacion() { return puntuacion; }
    public String getObservaciones() { return observaciones; }
}
