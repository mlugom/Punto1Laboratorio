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
public class Producto {
    private String nombre;
    private float precio;

    public Producto(String nombre) {
        switch(nombre){
            case "agenda":
                this.precio = 20000;
                this.nombre = nombre;
                break;
            case "maleta":
                this.precio = 70000;
                this.nombre = nombre;
                break;
            case "cuaderno":
                this.precio = 4000;
                this.nombre = nombre;
                break;
            case "lapicero":
                this.precio = 800;
                this.nombre = nombre;
                break;
            case "corrector":
                this.precio = 1200;
                this.nombre = nombre;
                break;
            case "portaminas":
                this.precio = 3000;
                this.nombre = nombre;
                break;
            case "borrador":
                this.precio = 500;
                this.nombre = nombre;
                break;
            case "sacapuntas":
                this.precio = 1000;
                this.nombre = nombre;
                break;
            case "cartuchera":
                this.precio = 20000;
                this.nombre = nombre;
                break;
            case "kit_marcadores":
                this.precio = 15000;
                this.nombre = nombre;
                break;
            default:
                System.out.println("Este producto no lo vendemos aqui.");
                break;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
}
