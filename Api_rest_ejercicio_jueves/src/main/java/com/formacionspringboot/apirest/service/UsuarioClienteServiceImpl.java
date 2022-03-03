package com.formacionspringboot.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionspringboot.apirest.dao.DepartamentoDao;
import com.formacionspringboot.apirest.dao.UsuarioClienteDao;
import com.formacionspringboot.apirest.entity.UsuarioCliente;

@Service
public class UsuarioClienteServiceImpl implements UsuarioClienteService {

	@Autowired
	UsuarioClienteDao usuarioClienteDao;
	
	@Override
	public UsuarioCliente findByNombreUsuario(String nombre) {
		// TODO Auto-generated method stub
		return usuarioClienteDao.findByNombre(nombre);
	}

}
