package com.krakedev.juegos.entidades;

public class Carta {
	private String valor;//Representa el valor de la carta
	private int valorJuego;//Valor que tendrá la carta dentro del juego
	
	/*
	 *  "D" → Diamante, "T" → Trébol,  "CN" → Corazón Negro,  "CR" → Corazón Rojo.
	 */
	private String palo;//💎🖤❤️☘️
	
	//get and set
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getValorJuego() {
		return valorJuego;
	}

	public void setValorJuego(int valorJuego) {
		this.valorJuego = valorJuego;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}
	//Método Imprimir
	public void imprimir() {
		System.out.println("-------------Juego 21 Blackjack----------------");
		System.out.println("Valor de la carta: "+ valor);
		System.out.println("Valor juego: "+ valorJuego);
		System.out.println("El palo es: "+ palo);
		System.out.println("-----------------------------------------------");
	}
}
