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
import com.tavernainfo.model.Categoria;
import com.tavernainfo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<Categoria>> getCategoria() {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Categoria>> getCategoriaId(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.findById(id));
	}

	@PostMapping
	public ResponseEntity<Categoria> addCategoria(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategoria(@PathVariable Integer id){
		categoriaRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Categoria removida com sucesso");
	}
	
}
