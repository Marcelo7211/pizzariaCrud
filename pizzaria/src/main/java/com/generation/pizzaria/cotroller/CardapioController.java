package com.generation.pizzaria.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.generation.pizzaria.model.Cardapio;
import com.generation.pizzaria.repository.CardapioRepository;

@RestController
@RequestMapping("/cardapio")
//TODO Implementar CrosOringin
public class CardapioController {
	
	@Autowired
	private CardapioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Cardapio>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Cardapio> getById(@PathVariable long id){		
		return repository.findById(id).map(cardapio -> ResponseEntity.ok(cardapio))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());		
	}
	
	@PostMapping
	public ResponseEntity<Cardapio> post(@RequestBody Cardapio cardapio){
		//TODO Criar service para não permitir duplicidade
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(cardapio));
	}
	
	@PutMapping
	public ResponseEntity<Cardapio> put(@RequestBody Cardapio cardapio){		
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(cardapio));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	

}
