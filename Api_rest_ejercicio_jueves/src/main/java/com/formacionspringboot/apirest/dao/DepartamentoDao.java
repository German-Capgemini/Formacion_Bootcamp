package com.formacionspringboot.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionspringboot.apirest.entity.Departamento;

public interface DepartamentoDao extends CrudRepository<Departamento,Long> {

}
