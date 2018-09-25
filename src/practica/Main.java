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
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Entorno entorno = new Entorno();
        Estante[] estantes = new Estante[20];
        for(int i = 0; i <= 19; i++){
            switch(i){
                case 0:
                    estantes[i] = new Estante("agenda");
                    break;
                case 1:
                    estantes[i] = new Estante("agenda");
                    break;
                case 2:
                    estantes[i] = new Estante("maleta");
                    break;
                case 3:
                    estantes[i] = new Estante("maleta");
                    break;
                case 4:
                    estantes[i] = new Estante("cuaderno");
                    break;
                case 5:
                    estantes[i] = new Estante("cuaderno");
                    break;
                case 6:
                    estantes[i] = new Estante("lapicero");
                    break;
                case 7:
                    estantes[i] = new Estante("lapicero");
                    break;
                case 8:
                    estantes[i] = new Estante("corrector");
                    break;
                case 9:
                    estantes[i] = new Estante("corrector");
                    break;
                case 10:
                    estantes[i] = new Estante("portaminas");
                    break;
                case 11:
                    estantes[i] = new Estante("portaminas");
                    break;
                case 12:
                    estantes[i] = new Estante("borrador");
                    break;
                case 13:
                    estantes[i] = new Estante("borrador");
                    break;
                case 14:
                    estantes[i] = new Estante("sacapuntas");
                    break;
                case 15:
                    estantes[i] = new Estante("sacapuntas");
                    break;
                case 16:
                    estantes[i] = new Estante("cartuchera");
                    break;
                case 17:
                    estantes[i] = new Estante("cartuchera");
                    break;
                case 18:
                    estantes[i] = new Estante("kit_marcadores");
                    break;
                case 19:
                    estantes[i] = new Estante("kit_marcadores");
                    break;
                default:
                    System.out.println("Este producto no se adquiere aqui.");
                    break;
            }
        }
        boolean cond1 = true;
        boolean cond2 = true;
        while(cond1){
            Factura factura = new Factura("aa",0);
            while(cond2){
                System.out.println("Bienvenido. Escoja uno de los productos mostrados a continuacion:");
                System.out.println("agenda");
                System.out.println("maleta");
                System.out.println("cuaderno");
                System.out.println("lapicero");
                System.out.println("corrector");
                System.out.println("portaminas");
                System.out.println("borrador");
                System.out.println("sacapuntas");
                System.out.println("cartuchera");
                System.out.println("kit_marcadores");
                String producto = lectura.next();
                int numEstante;
                int numRobot;
                
                moverRobotHastaPedido(entorno,producto,estantes);
                numEstante = returnMoverRobotHastaPedido(entorno,producto,estantes);
                gestionarPedido(entorno,estantes,producto,lectura,factura,numEstante);
                numRobot = returnGestionarPedido(entorno);
                dejarThing(entorno,numRobot,producto,estantes,numEstante);
                System.out.print("Desea ordenar otro producto? (si/no): ");
                String respuesta = lectura.next();
                if(respuesta.equals("si")) cond2 = true;
                else{
                    System.out.print("Escriba su nombre por favor (separado por _): ");
                    String nombre = lectura.next();
                    System.out.println("Con cuanto dinero va a pagar?: ");
                    float valorRecibido = lectura.nextFloat();
                    factura.setCliente(nombre);
                    factura.setValorRecibido(valorRecibido);
                    factura.setTotal();
                    factura.setCambio();
                    hacerEnvio(entorno,factura);
                    cond2 = false;
                } 
            }
            System.out.println("Desea realizar otro pedido?(si/no): ");
            String respuesta = lectura.next();
            if(respuesta.equals("si")){
                cond1 = true;
                volverDeEnvio(entorno);
            }
            else{
                System.out.println("Gracias. Hasta luego.");
                cond1 = false;
                volverDeEnvio(entorno);
            }
        }
    }
    
    public static void moverDerecha(Entorno entorno,int j){
        for(int i = 0; i < 3; i++){
            entorno.getRobots()[j].turnLeft();
        }
    }
    
    public static int returnMoverRobotHastaPedido(Entorno entorno, String tipo, Estante[] estantes){
        if(tipo.equals("agenda")){
            if(estantes[1].getCajas()[0].getProductos()[0] == null){
                return 0;
            }else{
                return 1;
            }
        }else{
            int indice = 0;
            switch(tipo){
                case "maleta":
                    indice = 0;
                    break;
                case "cuaderno":
                    indice = 1;
                    break;
                case "lapicero":
                    indice = 2;
                    break;
                case "corrector":
                    indice = 3;
                    break;
                case "portaminas":
                    indice = 4;
                    break;
                case "borrador":
                    indice = 5;
                    break;
                case "sacapuntas":
                    indice = 6;
                    break;
                case "cartuchera":
                    indice = 7;
                    break;
                case "kit_marcadores":
                    indice = 8;
                    break;
            }
            if(estantes[((indice+2)*2)-1].getCajas()[0].getProductos()[0] == null){
                return ((indice+2)*2)-2;
            }else{
                return ((indice+2)*2)-1;
            }
        }
    }
    
    public static void moverRobotHastaPedido(Entorno entorno, String tipo, Estante[] estantes){
        for(int i = 0; i <= 9; i++){
            if(entorno.getRobots()[i].getAvenue() == 7 && entorno.getRobots()[i].getStreet() == i+2){
                entorno.getRobots()[i].move();
                if(i > 0){
                    moverDerecha(entorno,i);
                    for(int j = 0; j < i; j++){
                        entorno.getRobots()[i].move();
                    }
                    entorno.getRobots()[i].turnLeft();
                }
                for(int j = 0; j < 2; j++){
                    entorno.getRobots()[i].move();
                    moverDerecha(entorno,i);
                }
                for(int j = 0; j < 3; j++){
                    entorno.getRobots()[i].move();
                }
                
                if(tipo.equals("agenda")){
                    if(estantes[1].getCajas()[0].getProductos()[0] == null){
                        entorno.getRobots()[i].move();
                        if(entorno.getRobots()[i].canPickThing()){
                            entorno.getRobots()[i].pickThing();                           
                        } 
                        moverDerecha(entorno,i);
                        for(int j = 0; j < 10; j++){
                            entorno.getRobots()[i].move();
                        }
                    }else{
                        entorno.getRobots()[i].move();
                        entorno.getRobots()[i].move();
                        if(entorno.getRobots()[i].canPickThing()){
                            entorno.getRobots()[i].pickThing();                            
                        }
                        moverDerecha(entorno,i);
                        while(entorno.getRobots()[i].frontIsClear()){
                            entorno.getRobots()[i].move();
                        }
                        moverDerecha(entorno,i);
                        entorno.getRobots()[i].move();
                        entorno.getRobots()[i].turnLeft();
                        entorno.getRobots()[i].move();
                    }
                }else{
                    entorno.getRobots()[i].move();
                    moverDerecha(entorno,i);
                    entorno.getRobots()[i].move();
                    int indice = 0;
                    switch(tipo){
                        case "maleta":
                            indice = 0;
                            break;
                        case "cuaderno":
                            indice = 1;
                            break;
                        case "lapicero":
                            indice = 2;
                            break;
                        case "corrector":
                            indice = 3;
                            break;
                        case "portaminas":
                            indice = 4;
                            break;
                        case "borrador":
                            indice = 5;
                            break;
                        case "sacapuntas":
                            indice = 6;
                            break;
                        case "cartuchera":
                            indice = 7;
                            break;
                        case "kit_marcadores":
                            indice = 8;
                            break;
                    }
                    for(int j = 0; j < indice; j++){
                        entorno.getRobots()[i].move();
                    }
                    if(estantes[((indice+2)*2)-1].getCajas()[0].getProductos()[0] == null){
                        if(entorno.getRobots()[i].canPickThing()){
                            entorno.getRobots()[i].pickThing();                           
                        }
                        for(int j = 0; j < 9-indice; j++){
                            entorno.getRobots()[i].move();
                        }
                    }else{
                        entorno.getRobots()[i].turnLeft();
                        entorno.getRobots()[i].move();
                        if(entorno.getRobots()[i].canPickThing()){
                            entorno.getRobots()[i].pickThing();                            
                        }
                        moverDerecha(entorno,i);
                        while(entorno.getRobots()[i].frontIsClear()){
                            entorno.getRobots()[i].move();
                        }
                        moverDerecha(entorno,i);
                        entorno.getRobots()[i].move();
                        entorno.getRobots()[i].turnLeft();
                        entorno.getRobots()[i].move();                        
                    }
                }
                while(entorno.getRobots()[i].frontIsClear()){
                    entorno.getRobots()[i].move();
                }
                moverDerecha(entorno,i);
                while(entorno.getRobots()[i].frontIsClear()){
                    entorno.getRobots()[i].move();
                }
                break;
            }
        }
    }
    
    public static int returnGestionarPedido(Entorno entorno){
        int i;
        for(i = 0; i <= 9; i++){
            if(entorno.getRobots()[i].countThingsInBackpack() > 0){
                break;
            }
        }
        return i;
    }
    
    public static void gestionarPedido(Entorno entorno, Estante[] estantes, String tipo, Scanner lectura, Factura factura, int numEstante){
        int i;
        for(i = 0; i <= 9; i++){
            if(entorno.getRobots()[i].getStreet() == 13 && entorno.getRobots()[i].getAvenue() == 5){
                if(entorno.getRobots()[i].countThingsInBackpack() == 1){
                    estantes[numEstante].mostrarContenido();                    
                    System.out.print("Desea comprar algun producto? (si/no): ");
                    String respuesta = lectura.next();
                    if(respuesta.equals("si")){
                        factura.anadirProducto(estantes[numEstante].getCajas()[0].getProductos()[0]);
                        estantes[i].eliminarProducto();
                    }
                }
                moverDerecha(entorno,i);
                while(entorno.getRobots()[i].frontIsClear()){
                    entorno.getRobots()[i].move();
                }
                moverDerecha(entorno,i);
                parquear(entorno,i);
                break;
            }
        }
    }
    
    public static void parquear(Entorno entorno, int i){
        entorno.getRobots()[i].move();
        entorno.getRobots()[i].turnLeft();
        for(int j = 0; j < 9-i; j++){
            entorno.getRobots()[i].move();
        }
        moverDerecha(entorno,i);
        entorno.getRobots()[i].move();
        entorno.getRobots()[i].turnLeft();
        entorno.getRobots()[i].turnLeft();
    }
    
    public static void dejarThing(Entorno entorno, int i, String tipo, Estante[] estantes, int algo){
        for(int k = 0; k <= 9; k++){
            if(i == k){
                entorno.getRobots()[k].move();
                if(i > 0){
                    moverDerecha(entorno,k);
                    for(int j = 0; j < i; j++){
                        entorno.getRobots()[k].move();
                    }
                    entorno.getRobots()[k].turnLeft();
                }
                for(int j = 0; j <= 1; j++){
                    entorno.getRobots()[k].move();
                    moverDerecha(entorno,k);
                }
                for(int j = 0; j <= 2; j++){
                    entorno.getRobots()[k].move();
                }
                if(algo == 0){
                    entorno.getRobots()[k].move();
                    entorno.getRobots()[k].putThing();
                    moverDerecha(entorno,k);
                    for(int j = 0; j < 10; j++){
                        entorno.getRobots()[k].move();
                    }
                }else if(algo == 1){
                    entorno.getRobots()[k].move();
                    entorno.getRobots()[k].move();
                    entorno.getRobots()[k].putThing();
                    moverDerecha(entorno,k);
                    while(entorno.getRobots()[k].frontIsClear()){
                        entorno.getRobots()[k].move();
                    }
                    moverDerecha(entorno,k);
                    entorno.getRobots()[k].move();
                    entorno.getRobots()[k].turnLeft();
                }else{
                    entorno.getRobots()[k].move();
                    moverDerecha(entorno,k);
                    entorno.getRobots()[k].move();
                    int indice = 0;
                    switch(tipo){
                        case "maleta":
                            indice = 0;
                            break;
                        case "cuaderno":
                            indice = 1;
                            break;
                        case "lapicero":
                            indice = 2;
                            break;
                        case "corrector":
                            indice = 3;
                            break;
                        case "portaminas":
                            indice = 4;
                            break;
                        case "borrador":
                            indice = 5;
                            break;
                        case "sacapuntas":
                            indice = 6;
                            break;
                        case "cartuchera":
                            indice = 7;
                            break;
                        case "kit_marcadores":
                            indice = 8;
                            break;
                    }
                    for(int j = 0; j < indice; j++){
                        entorno.getRobots()[k].move();
                    }
                    if(algo == (indice+2)*2-2){
                        entorno.getRobots()[k].putThing();
                        for(int j = 0; j < 9-indice; j++){
                            entorno.getRobots()[k].move();
                        }
                    }else{
                        entorno.getRobots()[k].turnLeft();
                        entorno.getRobots()[k].move();
                        entorno.getRobots()[k].putThing();
                        moverDerecha(entorno,k);
                        while(entorno.getRobots()[k].frontIsClear()){
                            entorno.getRobots()[k].move();
                        }
                        moverDerecha(entorno,k);
                        entorno.getRobots()[k].move();
                        entorno.getRobots()[k].turnLeft();
                        entorno.getRobots()[k].move();
                    }
                }
                for(int j = 0; j < 3; j++){
                    while(entorno.getRobots()[k].frontIsClear()){
                        entorno.getRobots()[k].move();
                    }
                    moverDerecha(entorno,k);
                }
                parquear(entorno,k);
            }
        }
    }
    
    public static void hacerEnvio(Entorno entorno, Factura factura){
        for(int i = 0; i < 10; i++){
            if(entorno.getRobots()[i].getAvenue() == 7 && entorno.getRobots()[i].getStreet() == i+2){
                entorno.getRobots()[i].move();
                if(i > 0){
                    moverDerecha(entorno,i);
                    for(int j = 0; j < i; j++){
                        entorno.getRobots()[i].move();
                    }
                    entorno.getRobots()[i].turnLeft();
                }
                for(int j = 0; j < 2; j++){
                    entorno.getRobots()[i].move();
                    moverDerecha(entorno,i);
                }
                for(int j = 0; j < 4; j++){
                    entorno.getRobots()[i].move();
                }
                moverDerecha(entorno,i);
                while(entorno.getRobots()[i].frontIsClear()){
                    entorno.getRobots()[i].move();
                }
                moverDerecha(entorno,i);
                while(entorno.getRobots()[i].frontIsClear()){
                    entorno.getRobots()[i].move();
                }
                entorno.getRobots()[i].turnLeft();
                entorno.getRobots()[i].move();
                moverDerecha(entorno,i);
                while(entorno.getRobots()[i].frontIsClear()){
                    entorno.getRobots()[i].move();
                }
                moverDerecha(entorno,i);
                while(entorno.getRobots()[i].frontIsClear()){
                    entorno.getRobots()[i].move();
                }
                System.out.println("Su pedido ha sido enviado.");
                factura.generarFactura();
                break;
            }
        }
    }
    
    public static void volverDeEnvio(Entorno entorno){
        for(int i = 0; i < 10; i++){
            if(entorno.getRobots()[i].getStreet() == 1 && entorno.getRobots()[i].getAvenue() == 1){
                for(int j = 0; j < 2; j++){
                    moverDerecha(entorno,i);
                    while(entorno.getRobots()[i].frontIsClear()){
                        entorno.getRobots()[i].move();
                    }
                }
                entorno.getRobots()[i].turnLeft();
                for(int j = 0; j < 2; j++){
                    entorno.getRobots()[i].move();
                }
                parquear(entorno,i);
                break;
            }
        }
    }
}
