package com.krakedev.juegos.servicios;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;

public class Dealer {
	ArrayList<Carta> naipe = new ArrayList<Carta>();

	// get and set
	public ArrayList<Carta> getNaipe() {
		return naipe;
	}

	public void setNaipe(ArrayList<Carta> naipe) {
		this.naipe = naipe;
	}

	//---------------------------------------------------------------------------------------
	//--------------------------Método generarNaipe()---------------------------------------
	public void generarNaipe() {
		//ArrayList auxiliar de String palos
		
		ArrayList<String> palos=new ArrayList<String>();
		palos.add("☘️");//trebol
		palos.add("🖤");//corazón negro
		palos.add("❤️");//corazón rojo
		palos.add("💎");//diamante
		
		
		//ArrayList auxiliar de String valores
		
		ArrayList<String> valores = new ArrayList<String>();
		valores.add("A");//Añado el AS
		//for para añadir los números a partir del 2-10
		for(int i =2; i<=10; i++) {
			String numero = i+"";
			valores.add(numero);
		}
		//Se agregan además los valores J, Q, K
		valores.add("J");
		valores.add("Q");
		valores.add("K");
		
		//Generar las cartas con el forEach
		
		
		//for dentro de otro for
		// Doble bucle: recorre palos y valores
		//recorro los palos y los guardo en una variable
		for(String palo: palos) {
			//recorro los valores y los guardo en una variable
			for(String valor: valores) {
				
				Carta cartas=new Carta();//instancia de Carta
				
				//se añade el palo
				cartas.setPalo(palo);
				//se añade el valor
				cartas.setValor(valor);
				
				naipe.add(cartas);//52 cartas en naipe
			}
		}
			
	}
		
	}
