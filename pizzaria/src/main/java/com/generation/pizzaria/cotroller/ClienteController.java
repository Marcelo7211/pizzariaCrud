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

import com.generation.pizzaria.model.Cliente;
import com.generation.pizzaria.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
//TODO Implementar CrosOringin
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/por-nome/{nome}")
	public ResponseEntity<List<Cliente>> getAllByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/por-idade/{idade}")
	public ResponseEntity<List<Cliente>> getAllByIdade(@PathVariable int idade) {
		return ResponseEntity.ok(repository.pegarPorIdadeMaiorQue(idade));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable long id){		
		return repository.findById(id).map(cliente -> ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());		
	}
	
	@PostMapping
	public ResponseEntity<Cliente> post(@RequestBody Cliente cliente){
		//TODO Criar service para não permitir duplicidade
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(cliente));
	}
	
	@PutMapping
	public ResponseEntity<Cliente> put(@RequestBody Cliente cliente){		
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(cliente));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
