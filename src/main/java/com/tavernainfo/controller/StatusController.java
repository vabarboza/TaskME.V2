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
import com.tavernainfo.model.Status;
import com.tavernainfo.repository.StatusRepository;

@RestController
@RequestMapping("/status")
public class StatusController {
	
	@Autowired
	private StatusRepository statusRepository;
	
	@GetMapping
	public ResponseEntity<List<Status>> getStatus(){
		return ResponseEntity.status(HttpStatus.OK).body(statusRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Status>> getStatusId(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(statusRepository.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Status> addStatus(@RequestBody Status status){
		return ResponseEntity.status(HttpStatus.CREATED).body(statusRepository.save(status));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Status> updateStatus(@RequestBody Status status){
		return ResponseEntity.status(HttpStatus.CREATED).body(statusRepository.save(status));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStatus(@PathVariable Integer id){
		statusRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Status removido com sucesso.");
	}

}
