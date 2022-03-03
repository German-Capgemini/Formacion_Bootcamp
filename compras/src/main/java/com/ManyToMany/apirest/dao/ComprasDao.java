package com.ManyToMany.apirest.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ManyToMany.apirest.entity.Compra;

@Repository
public interface ComprasDao extends CrudRepository<Compra, Long>{

	
	List<Compra> findByFecha(Date fecha);

	
}
