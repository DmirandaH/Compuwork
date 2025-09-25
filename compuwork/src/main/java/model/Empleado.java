/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Clase abstracta que representa a un empleado genérico.
 * Se valida que los datos sean correctos al asignarlos.
 */
public abstract class Empleado {
    private int id;
    private String nombre;
    private String tipo;
    private Departamento departamento;

    public Empleado(int id, String nombre, String tipo) {
        try {
            setId(id);
            setNombre(nombre);
            this.tipo = tipo;
        } catch (Exception e) {
            System.out.println("⚠️ Error al crear empleado: " + e.getMessage());
        }
    }

    public void asignarDepartamento(Departamento depto) {
        try {
            if (depto == null) {
                throw new IllegalArgumentException("Departamento no válido.");
            }
            this.departamento = depto;
            depto.agregarEmpleado(this);
        } catch (Exception e) {
            System.out.println("⚠️ No se pudo asignar el departamento: " + e.getMessage());
        }
    }

    public abstract ReporteDesempeno calcularDesempeno();

    // Getters y Setters con validación
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public Departamento getDepartamento() { return departamento; }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0.");
        }
        this.id = id;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty() || nombre.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre no puede estar vacío ni contener números.");
        }
        this.nombre = nombre;
    }
}
