package com.formacionspringboot.apirest.service;


import com.formacionspringboot.apirest.entity.UsuarioCliente;

public interface UsuarioClienteService {

	public UsuarioCliente findByNombreUsuario(String nombre);
}
