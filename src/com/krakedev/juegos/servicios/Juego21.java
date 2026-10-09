package com.krakedev.juegos.servicios;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;
import com.krakedev.juegos.entidades.Jugador;

public class Juego21 {
    private Dealer dealer;                  // atributo Dealer
    private ArrayList<Jugador> jugadores;   // lista de jugadores

    // Constructor de Juego21
    public Juego21() {
        jugadores = new ArrayList<>();
    }
  //------Cargar valores
    public void cargarValores(Dealer dealer) {
    	//Guardo el naipe
        ArrayList<Carta> valorCarta = dealer.getNaipe();
        //for each del naipe
        for (Carta carta : valorCarta) {
        	//Guardo el valor
            String valor = carta.getValor();
            //Condicio para agregar valorJuego
            if (valor.equals("A")) {
                carta.setValorJuego(11);
            } else if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
                carta.setValorJuego(10);
            } else {
                // aquí son números del 2 al 10
                int numero = Integer.parseInt(valor);//convierto el valor en int
                carta.setValorJuego(numero);//le paso el valor
            }
        }
    }


    //------------------------------------------------
    //------método inicializar
    public void inicializar() {
        dealer = new Dealer();       // inicializa el dealer
        cargarValores(dealer);       // asigna valores a las cartas
    }

    //------------------------------------------------
    //------método agregarJugador
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    //------------------------------------------------
    //------método repartirCarta
    public void repartirCarta(Jugador jugador) {
        Carta carta = dealer.entregarCarta(); // pide carta al dealer
        jugador.recibirCarta(carta);          // entrega la carta al jugador
    }
  //------------------------------------------------
   //------método repartirRonda
    public void repartirRonda() {
		for(Jugador players: jugadores) {
			repartirCarta(players);
		}
	}
    
}

