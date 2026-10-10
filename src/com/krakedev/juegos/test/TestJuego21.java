package com.krakedev.juegos.test;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21 {

    public static void main(String[] args) {
        // Instanciar el juego
        Juego21 juego21 = new Juego21();

        // Crear jugadores
        Jugador a = new Jugador("Carlos Barreto");
        Jugador b = new Jugador("Jean-Cloud Van Dam");
        Jugador c = new Jugador("Silvester Stalone");

        // Agregar jugadores al juego
        juego21.agregarJugador(a);
        juego21.agregarJugador(b);
        juego21.agregarJugador(c);

        // Inicializar dealer y cargar valores
        juego21.inicializar();

        // Repartir una ronda (cada jugador recibe una carta)
        //juego21.repartirRonda();
        
       //Primera prueba (una sola ejecución): 
        //juego21.jugar();
        
        // Imprimir cartas de cada jugador
        //a.imprimir();
        //b.imprimir();
        //c.imprimir();

        // Verificar que esas cartas ya salieron del naipe
        juego21.getDealer().imprimirNaipe(); 
        
        //Segunda prueba (for de 10 iteraciones):
       for(int i=0; i<=10; i++) {
    	   ArrayList<Jugador> ganadores=juego21.jugar();
    	   if(juego21.getDealer().getNaipe().size()==0) {
    		   System.out.println("--Se acabó el naipe--");
    		   a.imprimir();
               b.imprimir();
               c.imprimir();
               juego21.getDealer().generarNaipe();
    		   
    	   }
    	   if(ganadores.size()>0) {
    		   for(int x=0; x<ganadores.size(); x++) {
	            	System.out.println("Gana: "+ganadores.get(x).getNickname());
	            	a.imprimir();
	                b.imprimir();
	                c.imprimir();
	            }
    		   break;
    	   }
       }
       
    }
}
