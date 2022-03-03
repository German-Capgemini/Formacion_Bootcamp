package com.formacionspringboot.apirest.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionspringboot.apirest.dao.ClienteDao;
import com.formacionspringboot.apirest.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{

	/*
	 * Fijarnos que no hay un método de servicio para update, sino que update
	 * lo hacemos en el controlador con un método que recoge un objeto (findById())
	 * lo modifica (con setter y getters) y lo guarda con save()
	 */
	
	@Autowired
	ClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}


	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		clienteDao.deleteById(id);
	}

	
	
	
	
	
	

}
