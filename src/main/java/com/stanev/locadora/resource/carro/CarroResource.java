package com.stanev.locadora.resource.carro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stanev.locadora.domain.carro.Carro;
import com.stanev.locadora.dto.carro.CarroPOST;
import com.stanev.locadora.service.carro.iCarroService;

@RestController
@RequestMapping(value = "v1/carros")
public class CarroResource {
	
	@Autowired
	private iCarroService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> listarCarros() {
        List<Carro> list = service.listarCarros();
        
        return ResponseEntity.status(HttpStatus.OK).body(list.toString());
	}

	 @RequestMapping(value = "modelos", method = RequestMethod.GET)
	    public ResponseEntity<List<String>> listarModelosCarros() {

	        return ResponseEntity.status(HttpStatus.OK).body(service.listarModeloCarros());
	}

	 @RequestMapping(value = "marcas", method = RequestMethod.GET)
	    public ResponseEntity<List<String>> listarMarcasCarros() {

	        return ResponseEntity.status(HttpStatus.OK).body(service.listarMarcaCarros());
	}
	 	 
	 @RequestMapping(value = "listar_marca", method = RequestMethod.GET)
	    public ResponseEntity<List<Carro>> listarCarrosPorMarcas(@RequestParam String marca) {
	        return ResponseEntity.status(HttpStatus.OK).body(service.listarCarrosPorMarcas(marca));
	 }       

	 @RequestMapping(value = "listar_modelo", method = RequestMethod.GET)
	    public ResponseEntity<List<Carro>> listarCarrosPorModelos(@RequestParam String modelo) {
	        return ResponseEntity.status(HttpStatus.OK).body(service.listarCarrosPorModelos(modelo));
	 }       

	 @RequestMapping(value = "listar_cor", method = RequestMethod.GET)
	    public ResponseEntity<List<Carro>> listarCarrosPorCores(@RequestParam String cor) {
	        return ResponseEntity.status(HttpStatus.OK).body(service.listarCarrosPorCores(cor));
	 }       

	 @RequestMapping(value = "buscar_marca_modelo", method = RequestMethod.GET)
	    public ResponseEntity<Optional<Carro>> buscarCarroPorMarcaModelo(@RequestParam String marca, @RequestParam String modelo) {
	        return ResponseEntity.status(HttpStatus.OK).body(service.buscarCarroPorMarcaModelo(marca, modelo));
	    }
	 
	   @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<Carro> cadastrarCarro(@RequestBody CarroPOST carro){
	        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarCarro(carro));
	    }
	   
}

