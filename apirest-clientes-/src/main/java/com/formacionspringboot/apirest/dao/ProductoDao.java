package com.formacionspringboot.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionspringboot.apirest.entity.Producto;


public interface ProductoDao extends CrudRepository<Producto,Long>{

}
