package frontend;

import backend.Task;
import backend.TaskManager;

import javax.swing.*;
import java.time.LocalDate;

public class TaskUI {
    private TaskManager manager;

    public TaskUI(TaskManager manager) {
        this.manager = manager;
    }

    public void mostrarMenu() {
        String[] opciones = {"Agregar", "Buscar", "Modificar", "Eliminar", "Ordenar Nombre", "Ordenar Fecha", "Procesar"};
        while (true) {
            int opcion = JOptionPane.showOptionDialog(null, "Gestor de Tareas",
                    "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, opciones, opciones[0]);

            try {
                switch (opcion) {
                    case 0 -> {
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        String desc = JOptionPane.showInputDialog("Descripción:");
                        LocalDate fecha = LocalDate.now();
                        manager.agregar(new Task(nombre, desc, fecha));
                    }
                    case 1 -> {
                        String nombre = JOptionPane.showInputDialog("Nombre a buscar:");
                        JOptionPane.showMessageDialog(null, manager.buscar(nombre));
                    }
                    case 2 -> {
                        String nombre = JOptionPane.showInputDialog("Nombre a modificar:");
                        String desc = JOptionPane.showInputDialog("Nueva descripción:");
                        manager.modificar(nombre, desc);
                    }
                    case 3 -> {
                        String nombre = JOptionPane.showInputDialog("Nombre a eliminar:");
                        manager.eliminar(nombre);
                    }
                    case 4 -> JOptionPane.showMessageDialog(null, manager.ordenarPorNombre());
                    case 5 -> JOptionPane.showMessageDialog(null, manager.ordenarPorFecha());
                    case 6 -> manager.procesarEnParalelo();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
}
