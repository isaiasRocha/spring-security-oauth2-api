package com.project.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dto.UsuarioDTO;
import com.project.model.Usuario;

/**
 * 
 * @author RochaDev
 *
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query(value="", nativeQuery = true)
	public Optional<Usuario> findByLogin(String login);
    	
	@Query("select new com.project.dto.UsuarioDTO(u.pkUsuario, u.nome) from Usuario u"
			+ " where upper(u.nome) like %?1%")
	public List<UsuarioDTO> listaUsuario(String textoBusca);
	
}