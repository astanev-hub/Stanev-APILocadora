package com.stanev.locadora.service.carro;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.stanev.locadora.domain.carro.Carro;
import com.stanev.locadora.dto.carro.CarroPOST;
import com.stanev.locadora.repository.carro.CarroRepository;

@Service
public class CarroService implements iCarroService{

	@Autowired
	private CarroRepository carroRepository;
	
	@Override
	public List<Carro> listarCarros() {
		return carroRepository.findAll();
	}

	@Override
	public List<String> listarModeloCarros() {
		return carroRepository.findAll().stream()
                .map(x -> x.getModelo().toUpperCase()).distinct()
                .collect(Collectors.toList());
	}

	@Override
	public List<String> listarMarcaCarros() {
		return carroRepository.findAll().stream()
                .map(x -> x.getMarca().toUpperCase()).distinct()
                .collect(Collectors.toList());
	}

	@Override
	public List<Carro> listarCarrosPorModelos(String modelo) {
		return carroRepository.findAll().stream()
                .filter(x -> x.getModelo().equals(modelo))
                .collect(Collectors.toList());
	}

	@Override
	public List<Carro> listarCarrosPorMarcas(String marca) {
		return carroRepository.findAll().stream()
                .filter(x -> x.getMarca().equals(marca))
                .collect(Collectors.toList());
	}

	@Override
	public List<Carro> listarCarrosPorCores(String cor) {
		return carroRepository.findAll().stream()
                .filter(x -> x.getCor().contains(cor))
                .collect(Collectors.toList());
	}
	
    @Override
    public Optional<Carro> buscarCarroPorMarcaModelo(String marca, String modelo) {
        return carroRepository.findFirstCarroByMarcaAndModeloEquals(marca, modelo);
    }

    @Override
    public Carro cadastrarCarro(CarroPOST carro) {
        return carroRepository.save(new Carro(null, carro.getMarca(), carro.getModelo(), carro.getCor(), carro.getPlaca(), carro.getDiaria()));
    }
    
    @Override
    public Optional<Carro> excluirCarro(Integer codigo) {
    	Carro carro = carroRepository.findById(codigo).orElse(null);
    	if (carro == null) throw new RestClientException("Carro not found for delete");
    	carroRepository.delete(carro);
    	return Optional.ofNullable(carro);
    } 

    @Override
    public Carro atualizarCarro(Carro carro) {
    	return carroRepository.save(carro);
    }
    
}
