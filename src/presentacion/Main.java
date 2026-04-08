package presentacion;

import logicaNegocio.*;
import entidades.Usuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UsuarioService us = new UsuarioService();
        AccesoService as = new AccesoService();

        while (true) {
            System.out.println("\n=== SISTEMA DE ACCESO ===");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Registrar Entrada");
            System.out.println("3. Registrar Salida");
            System.out.println("4. Listar Usuarios");
            System.out.println("5. Eliminar Usuario");
            System.out.println("6. Ver historial de accesos");
            System.out.println("7. Ver tiempo total en laboratorio");
            System.out.println("8. Salir");

            System.out.print("Opción: ");
            int op = sc.nextInt();
            sc.nextLine();

            try {
                switch (op) {

                    case 1:
                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Rol (Estudiante/Docente): ");
                        String rol = sc.nextLine();

                        us.registrarUsuario(id, nombre, rol);
                        System.out.println("Usuario registrado correctamente");
                        break;

                    case 2:
                        System.out.print("ID Usuario: ");
                        as.registrarEntrada(sc.nextLine());
                        System.out.println("Entrada registrada");
                        break;

                    case 3:
                        System.out.print("ID Usuario: ");
                        as.registrarSalida(sc.nextLine());
                        System.out.println("Salida registrada");
                        break;

                    case 4:
                        for (Usuario u : us.listarUsuarios()) {
                            System.out.println(u.getId() + " - " + u.getNombre() + " - " + u.getRol());
                        }
                        break;

                    case 5:
                        System.out.print("ID a eliminar: ");
                        us.eliminarUsuario(sc.nextLine());
                        System.out.println("Usuario eliminado");
                        break;

                    case 6:
                        System.out.print("ID Usuario: ");
                        String idHist = sc.nextLine();

                        as.obtenerHistorial(idHist).forEach(a -> {
                            System.out.println("Entrada: " + a.getFechaEntrada() +
                                    " | Salida: " + a.getFechaSalida());
                        });
                        break;

                    case 7:
                        System.out.print("ID Usuario: ");
                        String idTiempo = sc.nextLine();

                        long minutos = as.calcularTiempoTotal(idTiempo);

                        long horas = minutos / 60;
                        long mins = minutos % 60;

                        System.out.println("Tiempo total: " + horas + "h " + mins + "min");
                        break;

                    case 8:
                        System.out.println("Saliendo...");
                        sc.close(); // 🔥 SOLUCIÓN AL WARNING
                        return;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}