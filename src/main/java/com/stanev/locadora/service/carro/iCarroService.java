package com.stanev.locadora.service.carro;

import java.util.List;
import java.util.Optional;

import com.stanev.locadora.domain.carro.Carro;
import com.stanev.locadora.dto.carro.CarroPOST;

public interface iCarroService {

    List<Carro> listarCarros();

    List<String> listarModeloCarros();

    List<String> listarMarcaCarros();    

	List<Carro> listarCarrosPorModelos(String modelo);

    List<Carro> listarCarrosPorMarcas(String marca);

    List<Carro> listarCarrosPorCores(String marca);
    
    Optional<Carro> buscarCarroPorMarcaModelo(String marca, String modelo);
    
    Carro cadastrarCarro(CarroPOST carro);
    
    Optional<Carro> excluirCarro(Integer codigo);

    Carro atualizarCarro(Carro carro);
}
