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
import becker.robots.*;
public class Entorno {
    private Robot[] robots;
    private City city;
    /**
     * 
     * @param city parametro que se entrega en el main. 
     */
    public Entorno(City city) {
        this.city = city;
        this.robots = new Robot[10];
        for(int i = 0; i < 10; i++){
            this.robots[i] = new Robot(this.city, i, i, Direction.WEST);
        }
        //Está pendiente la creacion de todo el entorno. Hay que hacer el diseño en papel primero.
    }
}
