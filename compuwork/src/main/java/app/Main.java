package app;

import model.Departamento;
import model.Empleado;
import model.EmpleadoPermanente;
import model.EmpleadoTemporal;
import model.ReporteDesempeno;

import java.util.*;

/**
 * Clase principal que gestiona un menú en consola
 * para manejar empleados, departamentos y reportes.
 */
public class Main {

    // Almacenes en memoria
    private static List<Empleado> empleados = new ArrayList<>();
    private static List<Departamento> departamentos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA COMPUWORK =====");
            System.out.println("1. Crear departamento");
            System.out.println("2. Crear empleado permanente");
            System.out.println("3. Crear empleado temporal");
            System.out.println("4. Asignar empleado a departamento");
            System.out.println("5. Generar reporte de desempeño");
            System.out.println("6. Listar empleados");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> crearDepartamento();
                case 2 -> crearEmpleadoPermanente();
                case 3 -> crearEmpleadoTemporal();
                case 4 -> asignarEmpleadoADepartamento();
                case 5 -> generarReporte();
                case 6 -> listarEmpleados();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    // ================== MÉTODOS DEL MENÚ ==================

    private static void crearDepartamento() {
        System.out.print("Ingrese ID del departamento: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Ingrese nombre del departamento: ");
        String nombre = sc.nextLine();

        departamentos.add(new Departamento(id, nombre));
        System.out.println("Departamento creado exitosamente.");
    }

    private static void crearEmpleadoPermanente() {
        System.out.print("Ingrese ID del empleado: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese salario mensual: ");
        double salario = sc.nextDouble();

        empleados.add(new EmpleadoPermanente(id, nombre, salario));
        System.out.println("Empleado permanente creado.");
    }

    private static void crearEmpleadoTemporal() {
        System.out.print("Ingrese ID del empleado: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese horas de contrato: ");
        int horas = sc.nextInt();

        empleados.add(new EmpleadoTemporal(id, nombre, horas));
        System.out.println("Empleado temporal creado.");
    }

    private static void asignarEmpleadoADepartamento() {
        System.out.print("Ingrese ID del empleado: ");
        int idEmpleado = sc.nextInt();
        System.out.print("Ingrese ID del departamento: ");
        int idDepto = sc.nextInt();

        Empleado emp = buscarEmpleado(idEmpleado);
        Departamento depto = buscarDepartamento(idDepto);

        if (emp != null && depto != null) {
            try {
                emp.asignarDepartamento(depto);
                System.out.println("Empleado asignado a departamento.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Empleado o departamento no encontrado.");
        }
    }

    private static void generarReporte() {
        System.out.print("Ingrese ID del empleado: ");
        int idEmpleado = sc.nextInt();

        Empleado emp = buscarEmpleado(idEmpleado);
        if (emp != null) {
            ReporteDesempeno reporte = emp.calcularDesempeno();
            System.out.println(reporte.generarReporte());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void listarEmpleados() {
        System.out.println("\n--- Lista de empleados ---");
        for (Empleado e : empleados) {
            String depto = (e.getDepartamento() != null) ? e.getDepartamento().getNombre() : "Sin asignar";
            System.out.println(e.getId() + " - " + e.getNombre() + " (" + e.getTipo() + ") - Depto: " + depto);
        }
    }

    // ================== MÉTODOS DE APOYO ==================

    private static Empleado buscarEmpleado(int id) {
        for (Empleado e : empleados) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    private static Departamento buscarDepartamento(int id) {
        for (Departamento d : departamentos) {
            if (d.getId() == id) return d;
        }
        return null;
    }
}
