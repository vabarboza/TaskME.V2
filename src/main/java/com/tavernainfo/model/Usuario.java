package com.tavernainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
    private int idUser;
    
    @Column(name="nome_user", nullable = false)
    private String nomeUser;
    
    @Column(name="email_user", nullable = false)
    private String emailUser;
    
    @Column(name="senha_user", nullable = false)
    private String senhaUser;
    
    @Column(name="tel_user", nullable = false)
    private String foneUser;
    
    @Column(name="ativo_user", nullable = false)
    private int ativo;
    
}
