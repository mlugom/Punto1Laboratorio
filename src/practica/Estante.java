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
public class Estante {
    private String tipo;
    private Caja[] cajas;

    public Estante(String tipo) {
        this.tipo = tipo;
        this.cajas = new Caja[3];
        for(int i = 0; i <= 2; i++){
            this.cajas[i] = new Caja(tipo);
        }
    }

    public String getTipo() {
        return tipo;
    }

    public Caja[] getCajas() {
        return cajas;
    }
    
    public void mostrarContenido(){
        boolean cond1 = false;
        for(int i = 0; i < 3; i++){
            if(this.cajas[i].getProductos()[0] != null){
                cond1 = cond1 || true;
            }
        }
        if(cond1 == true){
            int indice;
            int indice2;
            for(int i = 0; i < 3; i++){
                indice = i+1;
                System.out.println("Caja " + indice + ":");
                for(int j = 0; j < 7; j++){
                    indice2 = j+1;
                    if(this.cajas[i].getProductos()[j] != null){
                        System.out.println(indice2 + ". " + this.cajas[i].getProductos()[j].getNombre() + " - " + this.cajas[i].getProductos()[j].getPrecio());
                    }
                    System.out.println(" ");
                }
            }
        }
    }
    
    public void eliminarProducto(){
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <= 6; j++){
                if(this.cajas[i].getProductos()[j] != null){
                    this.cajas[i].eliminarProducto();
                    break;
                }
            }
            break;
        }
    }
}
