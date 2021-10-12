package com.tavernainfo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tarefa")
    private int idTarefa;
    
    @Column(name="titulo_tarefa" , nullable = false)
    private String tituloTarefa;
    
    @Column(name="desc_tarefa" , nullable = false)
    private String descTarefa;
    
    @Column(name="datainicio_tarefa" , nullable = false)
    private Date dataInicioTarefa;
    
    @Column(name="datafinal_tarefa" , nullable = false)
    private Date dataFinalTarefa;
    
    @OneToOne
    @JoinColumn(name="status_tarefa", referencedColumnName = "id_status" , nullable = false)
    private Status status;
    
    @OneToOne
    @JoinColumn(name="categoria_tarefa", referencedColumnName = "id_categoria" , nullable = false)
    private Categoria categoria;
    
    @OneToOne
    @JoinColumn(name="prioridade_tarefa", referencedColumnName = "id_prioridade" , nullable = false)
    private Prioridade prioridade;
    
    @OneToOne
    @JoinColumn(name="usuario_tarefa", referencedColumnName = "id_user" , nullable = false)
    private Usuario user;
}
