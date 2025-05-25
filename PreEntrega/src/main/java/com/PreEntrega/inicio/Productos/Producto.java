package com.PreEntrega.inicio.Productos;

public class Producto {
    private static int contadorProducto = 0;
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.id = contadorProducto++;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) this.precio = precio;
    }

    public void setStock(int stock) {
        if (stock >= 0) this.stock = stock;
    }

    public void mostrarInfo() {
        System.out.println("#########################");
        System.out.printf("""
                Id: %s
                Nombre: %s
                Precio: %s
                Stock: %s
                """, this.id, this.nombre, this.precio, this.stock);
        System.out.println("#########################");
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: $" + precio + ", Stock: " + stock;
    }
}


