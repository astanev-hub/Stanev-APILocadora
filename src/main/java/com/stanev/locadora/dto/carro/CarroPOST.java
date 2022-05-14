package com.stanev.locadora.dto.carro;

import java.io.Serializable;

public class CarroPOST implements Serializable{

	private String marca;
    private String modelo;
    private String cor;
    private String placa;
    private Double diaria;
    
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public String getCor() {
		return cor;
	}
	public String getPlaca() {
		return placa;
	}
	public Double getDiaria() {
		return diaria;
	}

}
