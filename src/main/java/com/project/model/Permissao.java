package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author RochaDev
 *
 */
@Entity
@Table(name = "permissao")
@Getter
@Setter
public class Permissao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pkpermissao")
	private Integer pkPermissao;
	private String descricao;

}
