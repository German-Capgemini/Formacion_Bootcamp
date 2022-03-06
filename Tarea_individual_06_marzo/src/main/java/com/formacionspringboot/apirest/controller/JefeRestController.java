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

import com.formacionspringboot.apirest.entity.Empleado;
import com.formacionspringboot.apirest.entity.Jefe;
import com.formacionspringboot.apirest.service.EmpleadoService;
import com.formacionspringboot.apirest.service.JefeService;

@RestController
@RequestMapping("/api")
public class JefeRestController {

	@Autowired
	JefeService servicio;
	
	@GetMapping("/jefes")
	public List<Jefe> index(){
		
		return servicio.findAll();
		
	}
	
	@GetMapping("/jefes/excepciones/{id}")
	public ResponseEntity<?> findClienteByIdExcepciones(@PathVariable Long id){
		
		Jefe jefe=null;
		Map<String,Object> response= new HashMap<>();
		
		try {
			
			jefe=servicio.findById(id);
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al realizar consulta a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		if(jefe==null) {
			
			response.put("mensaje", "El jefe ID: ".concat(id.toString().concat("no existe en la base de datos")));
			
			return 	new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Jefe>(jefe,HttpStatus.OK);
	}

	
	@PostMapping("/jefe/excepciones")
	public ResponseEntity<?> saveClienteExcepciones(@RequestBody Jefe jefe){
		
		Map<String,Object> response= new HashMap<>();
		
		
		try {
			
			jefe=servicio.save(jefe);
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al realizar un insert a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "El jefe ha sido creado con éxito");
		response.put("jefe", jefe);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
		
		
		
	}



	@PutMapping("/jefe/excepciones/{id}")
	public ResponseEntity<?> updateClienteExcepciones(@RequestBody Jefe jefe, @PathVariable Long id) {
	
		
		Map<String,Object> 	response = new HashMap<>();
		Jefe jefeActual=servicio.findById(id);
		
		if(jefeActual==null) {
			
			response.put("mensaje", "Error: no se pudo editar, el jefe con ID: "+id.toString()+"no existe en la BBDD");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			
		}
		

	try {	
		
		jefeActual.setDni(jefe.getDni());
		jefeActual.setNombre(jefe.getNombre());
		jefeActual.setSalario(jefe.getSalario());
		jefeActual.setTelefono(jefe.getTelefono());
		jefeActual.setDepartamento(jefe.getDepartamento());
		
		
		servicio.save(jefeActual);
		
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		response.put("mensaje", "Error al realizar un update a la base de datos");
		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	response.put("mensaje", "El jefe ha sido actualizado con éxito");
	response.put("jefe", jefeActual);
	
	return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
		
	}


	
	@DeleteMapping("/jefe/excepciones/{id}")
	public ResponseEntity<?> deleteClienteExcepciones(@PathVariable Long id) {
		Map<String,Object> 	response = new HashMap<>();
		Jefe jefeActual=servicio.findById(id);
		
		if(jefeActual==null) {
			
			response.put("mensaje", "Error: no se pudo editar, el jefe con ID: "+id.toString()+"no existe en la BBDD");
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
			
			response.put("jefe", jefeActual);
			response.put("mensaje", "Se ha borrado con exito el jefe");
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
		
		
	}
}
