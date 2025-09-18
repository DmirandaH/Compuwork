/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Clase base abstracta para empleados.
 * Contiene atributos comunes y obliga a implementar calcularDesempeno().
 */
public abstract class Empleado {
    private int id;
    private String nombre;
    private String tipo;
    private Departamento departamento;

    /**
     * Constructor básico.
     * @param id identificador único
     * @param nombre nombre completo
     * @param tipo "Permanente" o "Temporal"
     */
    public Empleado(int id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    /**
     * Asigna el empleado a un departamento. Lanza excepción si el departamento es null.
     */
    public void asignarDepartamento(Departamento depto) throws Exception {
        if (depto == null) {
            throw new Exception("Departamento no válido.");
        }
        this.departamento = depto;
        // agregramos al departamento (el método puede lanzar excepción)
        depto.agregarEmpleado(this);
    }

    /**
     * Cada subclase define cómo calcular el reporte de desempeño.
     */
    public abstract ReporteDesempeno calcularDesempeno();

    // === Getters ===
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public Departamento getDepartamento() { return departamento; }
}
