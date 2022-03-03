package com.project.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author RochaDev
 *
 */

@Getter
@Setter
public class UsuarioDTO {
	
	
	
	public UsuarioDTO(Integer pkUsuario, String nome) {
		super();
		this.pkUsuario = pkUsuario;
		this.nome = nome;
	}

	public Integer pkUsuario;
	public String nome;
	
	@Getter(AccessLevel.NONE)
	private String texto;

		public String getTexto() {
			return nome;
		}
	}


