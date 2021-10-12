package com.tavernainfo.controller;

import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RestController;
import com.tavernainfo.model.Prioridade;
import com.tavernainfo.repository.PrioridadeRepository;

@RestController
@RequestMapping("/prioridade")
public class PrioridadeController {
	@Autowired
	private PrioridadeRepository prioridadeRepository;
	
	@GetMapping
	public ResponseEntity<List<Prioridade>> getPrioridade(){
		return ResponseEntity.status(HttpStatus.OK).body(prioridadeRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Prioridade>> getPrioridadeId(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(prioridadeRepository.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Prioridade> addPrioridade(@RequestBody Prioridade prioridade){
		return ResponseEntity.status(HttpStatus.CREATED).body(prioridadeRepository.save(prioridade));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Prioridade> updatePrioridade(@RequestBody Prioridade prioridade){
		return ResponseEntity.status(HttpStatus.CREATED).body(prioridadeRepository.save(prioridade));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePrioridade(@PathVariable Integer id){
		prioridadeRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Prioridade removida com sucesso");
	}
}

