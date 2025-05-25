package com.PreEntrega.inicio;

import com.PreEntrega.inicio.Pedidos.pedidoService;
import com.PreEntrega.inicio.Productos.Producto;
import com.PreEntrega.inicio.Productos.productService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Producto> productos = new ArrayList<>();
    static pedidoService pedidoService = new pedidoService();
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int opcionUsuario;

        do {
            System.out.println("############################");
            System.out.println("SISTEMA DE GESTION - TECHLAB");
            System.out.println("############################");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar/Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Crear pedido");
            System.out.println("6. Listar pedidos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcionUsuario = entrada.nextInt();
            entrada.nextLine();

            switch (opcionUsuario) {
                case 1:
                    productService.agregarProducto(productos);
                    break;
                case 2:
                    productService.mostrarProductos(productos);
                    break;
                case 3:
                    productService.buscarActualizarProducto(productos);
                    break;
                case 4:
                    productService.eliminarProducto(productos);
                    break;
                case 5:
                    pedidoService.crearPedido(productos);
                    break;
                case 6:
                    pedidoService.listarPedidos();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcionUsuario != 7);
    }
}
