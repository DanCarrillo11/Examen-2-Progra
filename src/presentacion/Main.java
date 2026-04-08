package presentacion;

import logicaNegocio.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioService us = new UsuarioService();
        AccesoService as = new AccesoService();

        while (true) {
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Registrar Entrada");
            System.out.println("3. Registrar Salida");
            System.out.println("4. Listar Usuarios");
            System.out.println("5. Salir");

            int op = sc.nextInt();
            sc.nextLine();

            try {
                switch (op) {
                    case 1:
                        System.out.print("ID: ");
                        String id = sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Rol: ");
                        String rol = sc.nextLine();
                        us.registrarUsuario(id, nombre, rol);
                        break;

                    case 2:
                        System.out.print("ID Usuario: ");
                        as.registrarEntrada(sc.nextLine());
                        break;

                    case 3:
                        System.out.print("ID Usuario: ");
                        as.registrarSalida(sc.nextLine());
                        break;

                    case 4:
                        us.listarUsuarios().forEach(System.out::println);
                        break;

                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}