package app;

import model.Departamento;
import model.Empleado;
import model.EmpleadoPermanente;
import model.EmpleadoTemporal;
import model.ReporteDesempeno;

import java.util.*;

/**
 * Clase principal que gestiona un menú en consola
 * con validaciones en entradas usando métodos reutilizables.
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
            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1 -> crearDepartamento();
                case 2 -> crearEmpleadoPermanente();
                case 3 -> crearEmpleadoTemporal();
                case 4 -> asignarEmpleadoADepartamento();
                case 5 -> generarReporte();
                case 6 -> listarEmpleados();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("⚠️ Opción inválida.");
            }

        } while (opcion != 0);
    }

    // ================== MÉTODOS DEL MENÚ ==================

    private static void crearDepartamento() {
        int id = leerEntero("Ingrese ID del departamento: ");
        String nombre = leerTexto("Ingrese nombre del departamento: ");

        departamentos.add(new Departamento(id, nombre));
        System.out.println("✅ Departamento creado exitosamente.");
    }

    private static void crearEmpleadoPermanente() {
        int id = leerEntero("Ingrese ID del empleado: ");
        String nombre = leerTexto("Ingrese nombre: ");
        double salario = leerDouble("Ingrese salario mensual: ");

        empleados.add(new EmpleadoPermanente(id, nombre, salario));
        System.out.println("✅ Empleado permanente creado.");
    }

    private static void crearEmpleadoTemporal() {
        int id = leerEntero("Ingrese ID del empleado: ");
        String nombre = leerTexto("Ingrese nombre: ");
        int horas = leerEntero("Ingrese horas de contrato: ");

        empleados.add(new EmpleadoTemporal(id, nombre, horas));
        System.out.println("✅ Empleado temporal creado.");
    }

    private static void asignarEmpleadoADepartamento() {
        int idEmpleado = leerEntero("Ingrese ID del empleado: ");
        int idDepto = leerEntero("Ingrese ID del departamento: ");

        Empleado emp = buscarEmpleado(idEmpleado);
        Departamento depto = buscarDepartamento(idDepto);

        if (emp != null && depto != null) {
            emp.asignarDepartamento(depto);
            System.out.println("✅ Empleado asignado a departamento.");
        } else {
            System.out.println("⚠️ Empleado o departamento no encontrado.");
        }
    }

    private static void generarReporte() {
        int idEmpleado = leerEntero("Ingrese ID del empleado: ");

        Empleado emp = buscarEmpleado(idEmpleado);
        if (emp != null) {
            ReporteDesempeno reporte = emp.calcularDesempeno();
            System.out.println(reporte.generarReporte());
        } else {
            System.out.println("⚠️ Empleado no encontrado.");
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

    // ================== MÉTODOS DE VALIDACIÓN REUTILIZABLES ==================

    /** Lee un entero de forma segura con validación */
    private static int leerEntero(String mensaje) {
        int valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Error: Ingrese un número entero válido.");
                sc.nextLine(); // limpiar entrada inválida
            }
        }
    }

    /** Lee un double de forma segura con validación */
    private static double leerDouble(String mensaje) {
        double valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = sc.nextDouble();
                sc.nextLine(); // limpiar buffer
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Error: Ingrese un número decimal válido.");
                sc.nextLine(); // limpiar entrada inválida
            }
        }
    }

    /** Lee un texto (string) validando que no esté vacío */
    private static String leerTexto(String mensaje) {
        String valor;
        while (true) {
            System.out.print(mensaje);
            valor = sc.nextLine().trim();
            if (!valor.isEmpty() && !valor.matches(".*\\d.*")) { // no debe contener números
                return valor;
            } else {
                System.out.println("⚠️ Error: Ingrese un texto válido (sin números).");
            }
        }
    }
}
