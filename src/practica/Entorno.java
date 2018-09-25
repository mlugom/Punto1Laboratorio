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
    public Entorno(){
        this.city = new City(0,0,16,13);
        this.robots = new Robot[10];
        for(int i = 0; i < 10; i++){
            this.robots[i] = new Robot(this.city, i+2, 7, Direction.WEST);
        }
        
        //Paredes:
        for(int i = 0; i <= 10; i++){
            if(i != 4){
                Wall wall = new Wall(this.city,1,i,Direction.NORTH);
            }
            if(i == 0 || i == 2){
                Wall wall = new Wall(this.city,1,i,Direction.SOUTH);
            }
            if(i == 3 || i == 10){
                Wall wall = new Wall(this.city,1,i,Direction.EAST);
            }
            if(i == 5){
                Wall wall = new Wall(this.city,1,i,Direction.WEST);
            }
        }
        
        for(int i = 1; i <= 10; i++){
            if(i == 1 || i == 3 || i == 5 || i == 9){
                Wall wall = new Wall(this.city,2,i,Direction.WEST);
            }
            if(i == 1 || i == 3 || i == 7 || i == 10){
                Wall wall = new Wall(this.city,2,i,Direction.EAST);
            }
            if(i == 5){
                Wall wall = new Wall(this.city,2,i,Direction.SOUTH);
            }
            if(i == 6 || i == 7){
                Wall wall = new Wall(this.city,2,i,Direction.NORTH);
            }
        }
        
        for(int i = 3; i <= 10; i++){
            for(int j = 1; j <= 10; j++){
                if(j == 1 || j == 3 || j == 6 || j == 9){
                    Wall wall = new Wall(this.city,i,j,Direction.WEST);
                }
                if(j == 1 || j == 3 || j == 7 || j == 10){
                    Wall wall = new Wall(this.city,i,j,Direction.EAST);
                }
                if(j == 10 && i == 10){
                    Wall wall = new Wall(this.city,i,j,Direction.SOUTH);
                }
            }
        }
        
        for(int i = 1; i <= 9; i++){
            if(i == 1 || i == 3 || i == 9){
                Wall wall = new Wall(this.city,11,i,Direction.WEST);
            }
            if(i == 1 || i == 7 || i == 9){
                Wall wall = new Wall(this.city,11,i,Direction.EAST);
            }
            if(i == 3 || i == 4 || i == 6 || i == 7){
                Wall wall = new Wall(this.city,11,i,Direction.SOUTH);
            }
            if(i == 4 || i == 5){
                Wall wall = new Wall(this.city,11,i,Direction.NORTH);
            }
        }
        
        for(int i = 1; i <= 9; i+=4){
            Wall wall = new Wall(this.city,12,i,Direction.EAST);
            Wall wall2 = new Wall(this.city,12,i,Direction.WEST);
        }
        
        for(int i = 1; i <= 9; i++){
            if(i == 1 || i == 5){
                Wall wall = new Wall(this.city,13,i,Direction.WEST);
            }
            if(i == 1 || i == 9){
                Wall wall = new Wall(this.city,13,i,Direction.EAST);
            }
            if(i > 5 && i < 9){
                Wall wall = new Wall(this.city,13,i,Direction.NORTH);
                Wall wall2 = new Wall(this.city,13,i,Direction.SOUTH);
            }
            if(i == 9){
                Wall wall = new Wall(this.city,13,i,Direction.SOUTH);
            }
        }
        
        for(int i = 1; i <= 5; i++){
            if(i == 1){
                Wall wall = new Wall(this.city,14,i,Direction.WEST);
                Wall wall2 = new Wall(this.city,14,i,Direction.SOUTH);
            }
            if(i == 5){
                Wall wall = new Wall(this.city,14,i,Direction.EAST);
                Wall wall2 = new Wall(this.city,14,i,Direction.SOUTH);
            }
            if(i > 1 && i < 5){
                Wall wall = new Wall(this.city,14,i,Direction.NORTH);
                Wall wall2 = new Wall(this.city,14,i,Direction.SOUTH);
            }
        }
        
        //Things:
        for(int i = 1; i <= 10; i++){
            for(int j = 9; j <= 10; j++){
                Thing thing = new Thing(this.city,i,j);
            }
        }
    }
    
    public Robot[] getRobots(){
        return robots;
    }
    
    public City getCity(){
        return city;
    }
}
