package com.formacionspringboot.apirest.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import com.formacionspringboot.apirest.service.EmpleadoService;

@RestController
@RequestMapping("/api")
public class EmpleadoRestController {

	@Autowired
	EmpleadoService servicio;
	
	
	
	@GetMapping("/empleados")
	public List<Empleado> index(){
		
		return servicio.findAll();
		
	}
	
	@GetMapping("/empleados/excepciones/{id}")
	public ResponseEntity<?> findClienteByIdExcepciones(@PathVariable Long id){
		
		Empleado empleado=null;
		Map<String,Object> response= new HashMap<>();
		
		try {
			
			empleado=servicio.findById(id);
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al realizar consulta a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		if(empleado==null) {
			
			response.put("mensaje", "El empleado ID: ".concat(id.toString().concat("no existe en la base de datos")));
			
			return 	new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Empleado>(empleado,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/empleado/excepciones")
	public ResponseEntity<?> saveClienteExcepciones(@RequestBody Empleado empleado){
		
		Map<String,Object> response= new HashMap<>();
		
		
		try {
			
			empleado=servicio.save(empleado);
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al realizar un insert a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "El empleado ha sido creado con éxito");
		response.put("empleado", empleado);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
		
		
		
	}
	
	
	@PutMapping("/empleado/excepciones/{id}")
	public ResponseEntity<?> updateClienteExcepciones(@RequestBody Empleado empleado, @PathVariable Long id) {
	
		
		Map<String,Object> 	response = new HashMap<>();
		Empleado empleadoActual=servicio.findById(id);
		
		if(empleadoActual==null) {
			
			response.put("mensaje", "Error: no se pudo editar, el empleado con ID: "+id.toString()+"no existe en la BBDD");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			
		}
		

	try {	
		
		empleadoActual.setDni(empleado.getDni());
		empleadoActual.setNombre(empleado.getNombre());
		empleadoActual.setSalario(empleado.getSalario());
		empleadoActual.setTelefono(empleado.getTelefono());
		empleadoActual.setDepartamento(empleado.getDepartamento());
		
		
		servicio.save(empleadoActual);
		
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		response.put("mensaje", "Error al realizar un update a la base de datos");
		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	response.put("mensaje", "El empleado ha sido actualizado con éxito");
	response.put("cliente", empleadoActual);
	
	return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
		
	}
	
	
	@DeleteMapping("/empleado/excepciones/{id}")
	public ResponseEntity<?> deleteClienteExcepciones(@PathVariable Long id) {
		Map<String,Object> 	response = new HashMap<>();
		Empleado empleadoActual=servicio.findById(id);
		
		if(empleadoActual==null) {
			
			response.put("mensaje", "Error: no se pudo editar, el empleado con ID: "+id.toString()+"no existe en la BBDD");
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
			
			response.put("empleado", empleadoActual);
			response.put("mensaje", "Se ha borrado con exito el empleado");
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
		
		
	}
	
}
