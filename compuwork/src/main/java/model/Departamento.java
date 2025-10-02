/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un departamento.
 * Incluye validaciones en ID, nombre y manejo de empleados.
 */
public class Departamento {
    private int id;
    private String nombre;
    private List<Empleado> empleados;

    /**
     * Constructor del departamento con validaciones.
     * @param id identificador único del departamento
     * @param nombre nombre del departamento
     */
    public Departamento(int id, String nombre) {
        empleados = new ArrayList<>();
        try {
            setId(id);
            setNombre(nombre);
        } catch (Exception e) {
            System.out.println("⚠️ Error al crear departamento: " + e.getMessage());
            this.id = 0;
            this.nombre = "Desconocido";
        }
    }

    /**
     * Agrega un empleado al departamento, evitando duplicados.
     * @param e empleado a agregar
     */
    public void agregarEmpleado(Empleado e) {
        try {
            if (e == null) {
                throw new IllegalArgumentException("Empleado no válido.");
            }
            if (empleados.contains(e)) {
                throw new IllegalArgumentException("El empleado ya está en este departamento.");
            }
            empleados.add(e);
        } catch (Exception ex) {
            System.out.println("⚠️ No se pudo agregar empleado: " + ex.getMessage());
        }
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Empleado> getEmpleados() { return empleados; }

    // Setters con validación
    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0.");
        }
        this.id = id;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty() || nombre.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre del departamento no puede estar vacío ni contener números.");
        }
        this.nombre = nombre;
    }
}
