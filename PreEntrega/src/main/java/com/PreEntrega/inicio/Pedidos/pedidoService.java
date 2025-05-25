package com.PreEntrega.inicio.Pedidos;

import java.util.ArrayList;
import java.util.Scanner;

import com.PreEntrega.inicio.Productos.Producto;

public class pedidoService {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private Scanner entrada = new Scanner(System.in);
    
    public void crearPedido(ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
            return;
        }

        Pedido pedido = new Pedido();
        String continuar = "";

        do {
            System.out.println("\nProductos disponibles:");
            for (Producto producto : productos) {
                producto.mostrarInfo();
            }

            System.out.print("Ingrese ID del producto: ");
            int id = entrada.nextInt();
            Producto encontrado = null;

            for (Producto producto : productos) {
                if (producto.getId() == id) {
                    encontrado = producto;
                    break;
                }
            }

            if (encontrado == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }

            System.out.print("Cantidad: ");
            int cantidad = entrada.nextInt();

            if (cantidad > encontrado.getStock()) {
                System.out.println("Stock insuficiente.");
                continue;
            }

            pedido.agregarLinea(encontrado, cantidad);
            encontrado.setStock(encontrado.getStock() - cantidad);

            System.out.print("¿Agregar otro producto? (s/n): ");
            entrada.nextLine();
            continuar = entrada.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        if (!pedido.getLineas().isEmpty()) {
            pedidos.add(pedido);
            System.out.println("Pedido creado con éxito.");
        } else {
            System.out.println("El pedido está vacío.");
        }
    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println("Pedido:");
                for (LineaPedido linea : pedido.getLineas()) {
                    System.out.println(linea.getProducto().getNombre() + " x " + linea.getCantidad() + " = " + linea.getSubtotal());
                }
                System.out.println("Total del pedido: $" + pedido.getTotal());
                System.out.println("-----------------------------");
            }
        }
    }
}
