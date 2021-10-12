package com.tavernainfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tavernainfo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
