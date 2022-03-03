package com.formacionspringboot.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionspringboot.apirest.entity.Departamento;
import com.formacionspringboot.apirest.entity.Empleado;
import com.formacionspringboot.apirest.service.DepartamentoService;
import com.formacionspringboot.apirest.service.EmpleadoService;

@RestController
@RequestMapping("/api")
public class DepartamentoRestController {

	
	@Autowired
	DepartamentoService servicio;
	
	@GetMapping("/departamentos")
	public List<Departamento> index(){
		
		return servicio.findAll();
		
	}

	@GetMapping("/departamentos/excepciones/{id}")
	public ResponseEntity<?> findClienteByIdExcepciones(@PathVariable Long id){
		
		Departamento departamento=null;
		Map<String,Object> response= new HashMap<>();
		
		try {
			
			departamento=servicio.findById(id);
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al realizar consulta a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		if(departamento==null) {
			
			response.put("mensaje", "El departamento ID: ".concat(id.toString().concat("no existe en la base de datos")));
			
			return 	new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Departamento>(departamento,HttpStatus.OK);
	}

	
	@PostMapping("/departamento/excepciones")
	public ResponseEntity<?> saveClienteExcepciones(@RequestBody Departamento departamento){
		
		Map<String,Object> response= new HashMap<>();
		
		
		try {
			
			departamento=servicio.save(departamento);
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al realizar un insert a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "El departamento ha sido creado con éxito");
		response.put("departamento", departamento);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
		
		
		
	}

	
	@PutMapping("/departamento/excepciones/{id}")
	public ResponseEntity<?> updateClienteExcepciones(@RequestBody Departamento departamento, @PathVariable Long id) {
	
		
		Map<String,Object> 	response = new HashMap<>();
		Departamento departamentoActual=servicio.findById(id);
		
		if(departamentoActual==null) {
			
			response.put("mensaje", "Error: no se pudo editar, el departamento con ID: "+id.toString()+"no existe en la BBDD");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			
		}
		

	try {	
		
		departamentoActual.setNombre(departamento.getNombre());
		departamentoActual.setUbicacion(departamento.getUbicacion());
		

		servicio.save(departamentoActual);
		
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		response.put("mensaje", "Error al realizar un update a la base de datos");
		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	response.put("mensaje", "El departamento ha sido actualizado con éxito");
	response.put("departamento", departamentoActual);
	
	return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
		
	}

	
	
	@DeleteMapping("/departamento/excepciones/{id}")
	public ResponseEntity<?> deleteClienteExcepciones(@PathVariable Long id) {
		Map<String,Object> 	response = new HashMap<>();
		Departamento departamentoActual=servicio.findById(id);
		
		if(departamentoActual==null) {
			
			response.put("mensaje", "Error: no se pudo editar, el departamento con ID: "+id.toString()+"no existe en la BBDD");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			
		}
		
		
		try {	
			servicio.delete(id);
			
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				response.put("mensaje", "Error al realizar un delete a la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			response.put("departamento", departamentoActual);
			response.put("mensaje", "Se ha borrado con exito el departamento");
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
		
		
	}






}
