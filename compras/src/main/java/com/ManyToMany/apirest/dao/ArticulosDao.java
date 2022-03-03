package com.ManyToMany.apirest.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ManyToMany.apirest.entity.Articulo;

@Repository
public interface ArticulosDao extends CrudRepository<Articulo,Long> {

	List<Articulo> findByNombre(String nombre);

}
