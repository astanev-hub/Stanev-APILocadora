package com.stanev.locadora.domain.carro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "TB_CARROS")
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_CAR")
    private Integer codigo;

    @Column(name = "MARCA_CAR", nullable = false)
    @NotNull(message = "Por favor, informe o marca.")
    private String marca;

    @Column(name = "MODELO_CAR", nullable = false)
    @NotNull(message = "Por favor, informe o modelo.")
    private String modelo;

    @Column(name = "COR_CAR", nullable = false)
    @NotNull(message = "Por favor, informe a cor.")
    private String cor;

    @Column(name = "PLACA_CAR", nullable = false)
    @NotNull(message = "Por favor, informe a placa.")
    private String placa;

    @Column(name = "DIARIA_CAR", nullable = false)
    @NotNull(message = "Por favor, informe o valor da diaria.")
    private Double diaria;

    //Construtores
    public Carro(){}

	public Carro(Integer codigo, @NotNull(message = "Por favor, informe o marca.") String marca,
			@NotNull(message = "Por favor, informe o modelo.") String modelo,
			@NotNull(message = "Por favor, informe a cor.") String cor,
			@NotNull(message = "Por favor, informe a placa.") String placa,
			@NotNull(message = "Por favor, informe o valor da diaria.") Double diaria) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.diaria = diaria;
	}

	//Getters and Setters
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getDiaria() {
		return diaria;
	}

	public void setDiaria(Double diaria) {
		this.diaria = diaria;
	}

	//toString
	@Override
	public String toString() {
		return "Carro [codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", placa="
				+ placa + ", diaria=" + diaria + "]";
	}
}
