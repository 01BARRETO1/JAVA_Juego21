package com.krakedev.juegos.test;

import com.krakedev.juegos.servicios.Dealer;

public class TestAleatorio {

	public static void main(String[] args) {
		//instanciar dealer para ingresar a sus métodos
		Dealer dealer = new Dealer();
		//for de 100 iteraciones
		for(int i=0; i<=100; i++) {
			int numeroAleatorio=dealer.generarAleatorio(i);
			System.out.println(i+".- Numero:"+numeroAleatorio);
		}

	}

}
