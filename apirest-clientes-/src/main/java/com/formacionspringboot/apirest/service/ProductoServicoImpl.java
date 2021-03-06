package com.formacionspringboot.apirest.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionspringboot.apirest.dao.ClienteDao;
import com.formacionspringboot.apirest.dao.ProductoDao;
import com.formacionspringboot.apirest.entity.Producto;

@Service
public class ProductoServicoImpl implements ProductoService{

	@Autowired
	ProductoDao productoDao;
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>)productoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findById(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return productoDao.save(producto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productoDao.deleteById(id);;
		
	}

}
