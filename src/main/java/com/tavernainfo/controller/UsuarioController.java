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
import com.tavernainfo.model.Usuario;
import com.tavernainfo.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public ResponseEntity<List<Usuario>> getUser() {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> getUserId(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioRepository.save(usuario));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable Integer id) {
		usuarioRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Usuario removido com sucesso.");
	}
}
