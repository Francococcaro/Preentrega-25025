package com.PreEntrega.inicio.Productos;

import java.util.ArrayList;
import java.util.Scanner;

public class productService {
    public static Scanner entrada = new Scanner(System.in);

    public static void agregarProducto(ArrayList<Producto> productos) {
        System.out.print("Nombre del producto: ");
        String nombre = entrada.nextLine();
        System.out.print("Precio: ");
        double precio = entrada.nextDouble();
        System.out.print("Cantidad en stock: ");
        int cantidad = entrada.nextInt();
        Producto producto = new Producto(nombre, precio, cantidad);
        productos.add(producto);
        entrada.nextLine();
        System.out.println("Producto agregado!");
    }

    public static void mostrarProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\nLista de Productos");
            for (Producto producto : productos) {
                producto.mostrarInfo();
            }
        }
    }

    public static void buscarActualizarProducto(ArrayList<Producto> productos) {
        System.out.print("Buscar por (1-ID, 2-Nombre): ");
        int tipo = entrada.nextInt();
        entrada.nextLine();
        Producto producto = null;

        if (tipo == 1) {
            System.out.print("Ingrese ID: ");
            int id = entrada.nextInt();
            producto = buscarPorId(productos, id);
        } else if (tipo == 2) {
            System.out.print("Ingrese nombre: ");
            String nombre = entrada.nextLine();
            producto = buscarPorNombre(productos, nombre);
        }

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        System.out.println("Producto encontrado: " + producto);

        System.out.print("Actualizar precio (-1 para no cambiar): ");
        double precio = entrada.nextDouble();
        if (precio >= 0) producto.setPrecio(precio);

        System.out.print("Actualizar stock (-1 para no cambiar): ");
        int stock = entrada.nextInt();
        if (stock >= 0) producto.setStock(stock);

        System.out.println("Producto actualizado.");
    }

    public static void eliminarProducto(ArrayList<Producto> productos) {
        System.out.print("Ingrese ID del producto a eliminar: ");
        int id = entrada.nextInt();
        Producto producto = buscarPorId(productos, id);
        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static Producto buscarPorId(ArrayList<Producto> productos, int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id)
                return producto;
        }
        return null;
    }

    private static Producto buscarPorNombre(ArrayList<Producto> productos, String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre))
                return producto;
        }
        return null;
    }
}

