/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 * Representa a un empleado permanente.
 * Se valida el salario.
 */
public class EmpleadoPermanente extends Empleado {
    private double salarioMensual;

    public EmpleadoPermanente(int id, String nombre, double salarioMensual) {
        super(id, nombre, "Permanente");
        try {
            setSalarioMensual(salarioMensual);
        } catch (Exception e) {
            System.out.println("⚠️ Error al asignar salario: " + e.getMessage());
        }
    }

    @Override
    public ReporteDesempeno calcularDesempeno() {
        return new ReporteDesempeno(this, 9.0, "Desempeño estable y confiable.");
    }

    public double getSalarioMensual() { return salarioMensual; }

    public void setSalarioMensual(double salarioMensual) {
        if (salarioMensual <= 0) {
            throw new IllegalArgumentException("El salario debe ser mayor que 0.");
        }
        this.salarioMensual = salarioMensual;
    }
}
