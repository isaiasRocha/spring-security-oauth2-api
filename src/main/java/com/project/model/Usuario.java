package com.project.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author RochaDev
 *
 */
@Getter
@Setter
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"login"})})
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pkusuario")
    private Integer pkUsuario;
	private String nome; 
	private String login;
	private String senha;
	

	@ManyToMany(fetch = FetchType.EAGER) 
	@JoinTable(name = "usuario_permissao", joinColumns = @JoinColumn(name = "id")
		, inverseJoinColumns = @JoinColumn(name = "codigo_permissao"))
	private List<Permissao> permissoes;

}
