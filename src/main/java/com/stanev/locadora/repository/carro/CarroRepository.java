package com.stanev.locadora.repository.carro;

import com.stanev.locadora.domain.carro.Carro;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Integer>{

	Optional<Carro> findFirstCarroByMarcaAndModeloEquals(String marca, String modelo);
}