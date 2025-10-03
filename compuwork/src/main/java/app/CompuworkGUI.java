package app;

import model.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Interfaz gráfica para el sistema CompuWork usando JFrame y Swing.
 */
public class CompuworkGUI extends JFrame {

    private List<Empleado> empleados;
    private List<Departamento> departamentos;

    public CompuworkGUI() {
        empleados = new ArrayList<>();
        departamentos = new ArrayList<>();

        // Configuración de la ventana
        setTitle("CompuWork - Sistema de Gestión");
        setSize(520, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Margen y layout
        JPanel panel = new JPanel(new GridLayout(0, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        // Botones del menú
        JButton btnDepto = new JButton("Crear Departamento");
        JButton btnEmpPerm = new JButton("Crear Empleado Permanente");
        JButton btnEmpTemp = new JButton("Crear Empleado Temporal");
        JButton btnAsignar = new JButton("Asignar Empleado a Departamento");
        JButton btnReporte = new JButton("Generar Reporte de Desempeño");
        JButton btnListar = new JButton("Listar Empleados");
        JButton btnSalir = new JButton("Salir");

        // Eventos
        btnDepto.addActionListener(e -> crearDepartamento());
        btnEmpPerm.addActionListener(e -> crearEmpleadoPermanente());
        btnEmpTemp.addActionListener(e -> crearEmpleadoTemporal());
        btnAsignar.addActionListener(e -> asignarEmpleadoADepartamento());
        btnReporte.addActionListener(e -> generarReporte());
        btnListar.addActionListener(e -> listarEmpleados());
        btnSalir.addActionListener(e -> System.exit(0));

        // Agregar botones al panel
        panel.add(btnDepto);
        panel.add(btnEmpPerm);
        panel.add(btnEmpTemp);
        panel.add(btnAsignar);
        panel.add(btnReporte);
        panel.add(btnListar);
        panel.add(btnSalir);

        add(panel);
    }

    // ================== MÉTODOS DE OPCIONES ==================
    private void crearDepartamento() {
        try {
            String idStr = JOptionPane.showInputDialog(this, "Ingrese ID del departamento:");
            if (idStr == null) return; // Cancel pressed
            int id = Integer.parseInt(idStr.trim());

            String nombre = JOptionPane.showInputDialog(this, "Ingrese nombre del departamento:");
            if (nombre == null) return;

            departamentos.add(new Departamento(id, nombre));
            JOptionPane.showMessageDialog(this, "✅ Departamento creado exitosamente.");
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "⚠️ Error: el ID debe ser un número entero.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "⚠️ Error: " + ex.getMessage());
        }
    }

    private void crearEmpleadoPermanente() {
        try {
            String idStr = JOptionPane.showInputDialog(this, "Ingrese ID del empleado:");
            if (idStr == null) return;
            int id = Integer.parseInt(idStr.trim());

            String nombre = JOptionPane.showInputDialog(this, "Ingrese nombre:");
            if (nombre == null) return;

            String salStr = JOptionPane.showInputDialog(this, "Ingrese salario mensual:");
            if (salStr == null) return;
            double salario = Double.parseDouble(salStr.trim());

            empleados.add(new EmpleadoPermanente(id, nombre, salario));
            JOptionPane.showMessageDialog(this, "✅ Empleado permanente creado.");
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "⚠️ Error: ID y salario deben ser numéricos.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "⚠️ Error: " + ex.getMessage());
        }
    }

    private void crearEmpleadoTemporal() {
        try {
            String idStr = JOptionPane.showInputDialog(this, "Ingrese ID del empleado:");
            if (idStr == null) return;
            int id = Integer.parseInt(idStr.trim());

            String nombre = JOptionPane.showInputDialog(this, "Ingrese nombre:");
            if (nombre == null) return;

            String hrsStr = JOptionPane.showInputDialog(this, "Ingrese horas de contrato:");
            if (hrsStr == null) return;
            int horas = Integer.parseInt(hrsStr.trim());

            empleados.add(new EmpleadoTemporal(id, nombre, horas));
            JOptionPane.showMessageDialog(this, "✅ Empleado temporal creado.");
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "⚠️ Error: ID y horas deben ser números.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "⚠️ Error: " + ex.getMessage());
        }
    }

    private void asignarEmpleadoADepartamento() {
        try {
            String idEmpStr = JOptionPane.showInputDialog(this, "Ingrese ID del empleado:");
            if (idEmpStr == null) return;
            int idEmpleado = Integer.parseInt(idEmpStr.trim());

            String idDepStr = JOptionPane.showInputDialog(this, "Ingrese ID del departamento:");
            if (idDepStr == null) return;
            int idDepto = Integer.parseInt(idDepStr.trim());

            Empleado emp = buscarEmpleado(idEmpleado);
            Departamento depto = buscarDepartamento(idDepto);

            if (emp != null && depto != null) {
                emp.asignarDepartamento(depto);
                JOptionPane.showMessageDialog(this, "✅ Empleado asignado a departamento.");
            } else {
                JOptionPane.showMessageDialog(this, "⚠️ Empleado o departamento no encontrado.");
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "⚠️ Error: IDs deben ser numéricos.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "⚠️ Error: " + ex.getMessage());
        }
    }

    private void generarReporte() {
        try {
            String idStr = JOptionPane.showInputDialog(this, "Ingrese ID del empleado:");
            if (idStr == null) return;
            int idEmpleado = Integer.parseInt(idStr.trim());

            Empleado emp = buscarEmpleado(idEmpleado);
            if (emp != null) {
                ReporteDesempeno reporte = emp.calcularDesempeno();
                JOptionPane.showMessageDialog(this, reporte.generarReporte());
            } else {
                JOptionPane.showMessageDialog(this, "⚠️ Empleado no encontrado.");
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "⚠️ Error: El ID debe ser numérico.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "⚠️ Error: " + ex.getMessage());
        }
    }

    private void listarEmpleados() {
        StringBuilder sb = new StringBuilder("--- Lista de empleados ---\n");
        for (Empleado e : empleados) {
            String depto = (e.getDepartamento() != null) ? e.getDepartamento().getNombre() : "Sin asignar";
            sb.append(e.getId()).append(" - ").append(e.getNombre())
              .append(" (").append(e.getTipo()).append(") - Depto: ").append(depto).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    // ================== MÉTODOS DE APOYO ==================
    private Empleado buscarEmpleado(int id) {
        for (Empleado e : empleados) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    private Departamento buscarDepartamento(int id) {
        for (Departamento d : departamentos) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    // ================== MAIN ==================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CompuworkGUI().setVisible(true));
    }
}