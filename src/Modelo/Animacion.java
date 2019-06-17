/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

/**
 *
 * @author osarmiento
 */
public class Animacion extends AnimationTimer{
    int Ancho = 100;
    private Carro carro;
    private Llanta L1;
    private GraphicsContext lapiz;
    private Image fondo = null;
    private Image ufo = null;
    private int secuencia;
 
    public Animacion(GraphicsContext lapiz) {
        this.carro = new Carro(0,100);
        this.L1 = new Llanta(0, 200);
        this.lapiz = lapiz;
        this.fondo = new Image ("imagenes/fondo.png");
        
    }

    @Override
    public void handle(long l) {
        
        lapiz.clearRect(0, 0, 1024, 512);
        lapiz.drawImage(fondo,0,0);
       // this.ufo = new Image ("imagenes/ufo_" + this.secuencia +".png");
        
        lapiz.drawImage(this.ufo,0,0);
        if(this.secuencia == 5){
            secuencia = 0;
        }else {
            secuencia++;
                   
        }

        lapiz.setFill(Color.RED);
        lapiz.fillRect(this.carro.getX(), this.carro.getY()+275, 60, 30);
        lapiz.setFill(Color.BLACK);
        lapiz.fillOval(this.L1.getX(), this.L1.getY()+190, 30, 30);
        lapiz.fillOval(this.L1.getX()+30, this.L1.getY()+190, 30, 30);
        lapiz.setFill(Color.BROWN);
        lapiz.fillRect( 150, 380, 30, 40);
        
        lapiz.setStroke(Color.BLACK);
        lapiz.strokeRect(900, 10, 100, 25);
        lapiz.setFill(Color.GREEN);
        lapiz.fillRect(900, 10, Ancho, 25);
      
        
        this.carro.mover();
        this.L1.mover();
        
        Shape conv= new Rectangle(this.carro.getX(),this.carro.getY(),60,30);
        Shape obt1= new Rectangle(150, this.carro.getY(), 30, 40);
        Shape inter = SVGPath.intersect(conv,obt1);
        
        
        if(inter.getLayoutBounds().getWidth()!=-1){
            System.out.println(",nghgh");
            this.Ancho=this.Ancho-1;
        }
    }
    
}