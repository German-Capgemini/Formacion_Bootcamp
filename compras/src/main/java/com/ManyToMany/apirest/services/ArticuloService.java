package com.ManyToMany.apirest.services;

import java.util.Date;
import java.util.List;

import com.ManyToMany.apirest.entity.Articulo;

public interface ArticuloService {

public List<Articulo> findAll();
	
	public Articulo findById(Long id);
	
	public Articulo save(Articulo articulo);
	
	public void delete(Long id);
	
	List<Articulo> findByNombre(String nombre);
	
}
