package com.PreEntrega.inicio.Pedidos;

import com.PreEntrega.inicio.Productos.Producto;

import java.util.ArrayList;

public class Pedido {
    private static int contadorPedido = 0;
    private int id;
    private final ArrayList<LineaPedido> lineas;

    public Pedido() {
        this.id = contadorPedido++;
        this.lineas = new ArrayList<>();
    }

    public void agregarLinea(Producto producto, int cantidad) {
        lineas.add(new LineaPedido(producto, cantidad));
    }

    public double getTotal() {
        double total = 0;
        for (LineaPedido lineaPedido : lineas) {
            total += lineaPedido.getSubtotal();
        }
        return total;
    }

    public ArrayList<LineaPedido> getLineas() {
        return lineas;
    }
}
