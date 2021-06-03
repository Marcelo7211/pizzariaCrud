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

import com.generation.pizzaria.model.Pedido;
import com.generation.pizzaria.repository.PedidoRepository;

@RestController
@RequestMapping("/pedido")
//TODO Implementar CrosOringin
public class PedidoController {
	
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getById(@PathVariable long id){		
		return repository.findById(id).map(pedido -> ResponseEntity.ok(pedido))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());		
	}
	
	@PostMapping
	public ResponseEntity<Pedido> post(@RequestBody Pedido pedido){	
		//TODO Criar service para não permitir duplicidade
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(pedido));
	}
	
	@PutMapping
	public ResponseEntity<Pedido> put(@RequestBody Pedido pedido){		
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(pedido));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
