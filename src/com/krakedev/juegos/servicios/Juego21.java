package com.krakedev.juegos.servicios;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;
import com.krakedev.juegos.entidades.Jugador;

public class Juego21 {
	private Dealer dealer; // atributo Dealer
	private ArrayList<Jugador> jugadores; // lista de jugadores

	// Constructor de Juego21
	public Juego21() {
		jugadores = new ArrayList<>();
	}

	// Get and set
	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	// ------Cargar valores
	public void cargarValores(Dealer dealer) {
		// Guardo el naipe
		ArrayList<Carta> valorCarta = dealer.getNaipe();
		// for each del naipe
		for (Carta carta : valorCarta) {
			// Guardo el valor
			String valor = carta.getValor();
			// Condicio para agregar valorJuego
			if (valor.equals("A")) {
				carta.setValorJuego(11);
			} else if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
				carta.setValorJuego(10);
			} else {
				// aquí son números del 2 al 10
				int numero = Integer.parseInt(valor);// convierto el valor en int
				carta.setValorJuego(numero);// le paso el valor
			}
		}
	}

	// ------------------------------------------------
	// ------método inicializar
	public void inicializar() {
		dealer = new Dealer(); // inicializa el dealer

		cargarValores(dealer); // asigna valores a las cartas
	}

	// ------------------------------------------------
	// ------método agregarJugador
	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
	}

	// ------------------------------------------------
	// ------método repartirCarta
	public void repartirCarta(Jugador jugador) {
		Carta carta = dealer.entregarCarta(); // pide carta al dealer
		if (carta != null) {
			jugador.recibirCarta(carta); // entrega la carta al jugador
		} else {
			System.out.println("No se pudo repartir carta, se acabó el naipe");
			return;
		}
	}

	// ------------------------------------------------
	// ------método repartirRonda
	public void repartirRonda() {
		if (dealer.getNaipe().isEmpty()) {
	        System.out.println("--No se puede repartir ronda, el mazo está vacío--");
	        return; // salir del método sin repartir
	    }
		for (Jugador players : jugadores) {
			repartirCarta(players);
		}
		calcularTotal();
	}

	// ------------------------------------------------
	// ------método calcularTotal():
	public void calcularTotal() {

		for (Jugador jugador : jugadores) {
			int total = 0; // acumulador para cada jugador
			ArrayList<Carta> cartas = jugador.getCartas();

			for (Carta carta : cartas) {
				total += carta.getValorJuego(); // sumamos el valorJuego de cada carta

			}

			jugador.setPuntajeCartas(total); // guardamos el puntaje total en el jugador

		}

	}

	// ------------------------------------------------
	// ------10. Validar ganador
	public ArrayList<Jugador> validarGanador() {
		// Instancia un ArrayList<Jugador> ganadores y lo instancia.
		ArrayList<Jugador> ganadores = new ArrayList<Jugador>();
		// Barre la lista de jugadores y busca jugadores con puntaje = 21
		for (Jugador YouWin : jugadores) {
			if (YouWin.getPuntajeCartas() == 21) {
				ganadores.add(YouWin);
			}
		}
		return ganadores;
	}

	// ------------------------------------------------
	// ------11. Método jugar
	public ArrayList<Jugador> jugar() {
		// Lista de ganadores para devolver, return
		ArrayList<Jugador> ganadores = new ArrayList<Jugador>();

		// ciclo for 3 rondas
		for (int i = 0; i < 3; i++) {
			// Verificar que el mazo no esté vacío antes de repartir
	        if (dealer.getNaipe().isEmpty()) {
	            System.out.println("--Se acabó el naipe, no se puede repartir ronda--");
	            break; // salir del bucle de rondas
	        }
			repartirRonda();

			// Guardo los ganadores
			ArrayList<Jugador> rondaGanadores = validarGanador();

			// verificar si la lista tiene elementos
			if (rondaGanadores.size() > 0) {
				// Aquí entras solo si hay al menos un ganador en la ronda
				System.out.println("Hay ganadores en esta ronda ");
				// Añadir todos los ganadores de la ronda
				ganadores.addAll(rondaGanadores);
				for (int x = 0; x < ganadores.size(); x++) {
					System.out.println("Gana: " + ganadores.get(x).getNickname());
				}

				// Romper el bucle de rondas porque ya hubo ganadores
				break;
			}

		}

		return ganadores;
	}

}
