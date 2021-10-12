package com.tavernainfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tavernainfo.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

}
