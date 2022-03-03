package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Permissao;

/**
 * 
 * @author RochaDev
 *
 */
@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {

}
