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
public class Caja {
    private String tipo;
    private Producto[] productos;
    
    public Caja(String tipo){
        this.tipo = tipo;
        this.productos = new Producto[7];
        for(int i = 0; i < 10; i++){
            this.productos[i] = new Producto(tipo);
        }
    }

    public String getTipo() {
        return tipo;
    }

    public Producto[] getProductos() {
        return productos;
    }
    
    public boolean anadirProducto(Producto producto){
        if(producto.getNombre().equals(this.tipo)){
            int i = 0;
            while(this.productos[i] != null && i < 7){ //revisa si hay espacio
                i++;
            }
            
            if(i < 7){
                this.productos[i-1] = producto; //añade el producto en la posicion libre
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    
    public boolean eliminarProducto(){
        if(this.productos[0] == null){
            return false;
        }
        int i = 0;
        while(this.productos[i] != null && i < 7){
            i++;
        }

        if(i < 7){
            this.productos[i-1] = null;
            return true;
        }else{
            return false;
        }
    }
}
