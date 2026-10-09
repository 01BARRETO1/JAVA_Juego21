package com.krakedev.juegos.entidades;

import java.util.ArrayList;

public class Jugador {
	private String nickname;
	private ArrayList<Carta> cartas = new ArrayList<Carta>();

	// Cosntructor vacío
	public Jugador() {
	}
   //Constructor con nombre
	public Jugador(String nickname) {

		this.nickname = nickname;
	}

	// get and set
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	// -------método recibirCarta
	public void recibirCarta(Carta carta) {
		cartas.add(carta);
	}

	// -------------------------------------------
	// -------método imprimir
	public void imprimir() {
		System.out.println("Jugador: " + nickname);
		for (Carta cartas : cartas) {
			// COLORES
			final String RESET = "\u001B[0m";
			final String RED = "\u001B[31m";
			final String GREEN = "\u001B[32m";
			final String BLACK = "\u001B[30m";
			final String BLUE = "\u001B[34m";
			// VARIABLE PARA EL COLOR
			String color;
			// CONDICIONAL PARA VERIFICAR EL PALO
			if (cartas.getPalo().equals("☘️")) {
				color = GREEN;
				System.out.println(
						color + cartas.getPalo() + "" + cartas.getValor() + " → " + cartas.getValorJuego() + RESET);
			}
			if (cartas.getPalo().equals("🖤")) {
				color = BLACK;
				System.out.println(
						color + cartas.getPalo() + "" + cartas.getValor() + " → " + cartas.getValorJuego() + RESET);
			}
			if (cartas.getPalo().equals("❤️")) {
				color = RED;
				System.out.println(
						color + cartas.getPalo() + "" + cartas.getValor() + " → " + cartas.getValorJuego() + RESET);
			}
			if (cartas.getPalo().equals("💎")) {
				color = BLUE;
				System.out.println(
						color + cartas.getPalo() + "" + cartas.getValor() + " → " + cartas.getValorJuego() + RESET);
			}
		}
		System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°|");

	}

}
