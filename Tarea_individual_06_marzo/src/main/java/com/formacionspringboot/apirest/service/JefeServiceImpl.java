package com.formacionspringboot.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionspringboot.apirest.dao.JefeDao;
import com.formacionspringboot.apirest.entity.Jefe;

@Service
public class JefeServiceImpl implements JefeService{

	@Autowired
	JefeDao jefeDao;
	
	@Override
	public List<Jefe> findAll() {
		// TODO Auto-generated method stub
		return (List<Jefe>)jefeDao.findAll();
	}

	@Override
	public Jefe findById(Long id) {
		// TODO Auto-generated method stub
		return jefeDao.findById(id).orElse(null);
	}

	@Override
	public Jefe save(Jefe jefe) {
		// TODO Auto-generated method stub
		return jefeDao.save(jefe);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		jefeDao.deleteById(id);;
	}

}
