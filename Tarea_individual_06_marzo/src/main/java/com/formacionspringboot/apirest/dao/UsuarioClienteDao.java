package com.formacionspringboot.apirest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionspringboot.apirest.entity.UsuarioCliente;

@Repository
public interface UsuarioClienteDao extends CrudRepository<UsuarioCliente,Long>{

	public UsuarioCliente findByNombre(String nombre);
	
	
}
