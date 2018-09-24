/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

/**
 *
 * @author Equipo de Trabajo
 */
import java.util.ArrayList;
public class Factura {
    private String cliente;
    private Fecha fecha;
    private float valorRecibido;
    private float cambio;
    private ArrayList<Producto> productos;
    private float total;

    public Factura(String cliente, Fecha fecha, float valorRecibido) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.valorRecibido = valorRecibido;
        this.productos = new ArrayList<Producto>();
        this.total = 0;
        this.cambio = 0;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public float getValorRecibido() {
        return valorRecibido;
    }

    public void setValorRecibido(float valorRecibido) {
        this.valorRecibido = valorRecibido;
    }
    
    public void anadirProducto(Producto producto){
        this.productos.add(producto);
    }
    
    public float getTotal(){
        return total;
    }
    
    public void setTotal(){
        for(int i = 0; i < this.productos.size(); i++){
            this.total += this.productos.get(i).getPrecio();
        }
    }

    public float getCambio() {
        return cambio;
    }
    
    public void setCambio(){
        this.cambio = this.valorRecibido - this.total;
    }
    
    public void generarFactura(){
        System.out.println("Factura: ");
        for(int i = 0; i < this.productos.size(); i++){
            System.out.println(this.productos.get(i).getNombre() + "..............." + this.productos.get(i).getPrecio());
        }
        System.out.println("Total..............." + this.total);
        System.out.println(" ");
        System.out.println("Recibido..............." + this.valorRecibido);
        System.out.println("Cambio..............." + this.cambio);
    }
}
