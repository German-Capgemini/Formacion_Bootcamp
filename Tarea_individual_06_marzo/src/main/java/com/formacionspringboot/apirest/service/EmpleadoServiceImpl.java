package com.formacionspringboot.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionspringboot.apirest.dao.EmpleadoDao;
import com.formacionspringboot.apirest.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoDao empleadoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return (List<Empleado>)empleadoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Empleado findById(Long id) {
		// TODO Auto-generated method stub
		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Empleado save(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoDao.save(empleado);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		empleadoDao.deleteById(id);
	}

}
