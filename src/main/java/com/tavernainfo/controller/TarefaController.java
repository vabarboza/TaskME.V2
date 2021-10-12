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

import com.tavernainfo.model.Tarefa;
import com.tavernainfo.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@GetMapping
	public ResponseEntity<List<Tarefa>> getTarefa(){
		return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Tarefa>> getTarefaId(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Tarefa> addTarefa(@RequestBody Tarefa tarefa){
		return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefa));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> updateTarefa(@RequestBody Tarefa tarefa){
		return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefa));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTarefa(@PathVariable Integer id){
		tarefaRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Tarefa removida com sucesso");
	}
}
