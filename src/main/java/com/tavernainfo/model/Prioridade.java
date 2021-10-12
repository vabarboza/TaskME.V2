package com.tavernainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Prioridade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_prioridade")
	private Integer idPrioridade;
	
	@Column(name = "nome_prioridade", nullable = false)
	private String nomePrioridade;
}
