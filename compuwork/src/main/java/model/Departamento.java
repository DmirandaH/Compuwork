/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un departamento que contiene empleados.
 */
public class Departamento {
    private int id;
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    /**
     * Agrega un empleado a la lista del departamento.
     * Lanza excepción si empleado es null.
     * Evita duplicados.
     */
    public void agregarEmpleado(Empleado e) throws Exception {
        if (e == null) {
            throw new Exception("Empleado no válido.");
        }
        if (!empleados.contains(e)) {
            empleados.add(e);
        }
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() { return id; }
}
