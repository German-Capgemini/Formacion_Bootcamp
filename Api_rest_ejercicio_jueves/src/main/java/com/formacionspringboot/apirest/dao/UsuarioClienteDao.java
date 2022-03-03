package com.formacionspringboot.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionspringboot.apirest.entity.UsuarioCliente;


public interface UsuarioClienteDao extends CrudRepository<UsuarioCliente,Long>{

	public UsuarioCliente findByNombre(String nombre);
	
	
}
