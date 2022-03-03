package com.formacionspringboot.apirest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionspringboot.apirest.entity.Jefe;
import com.formacionspringboot.apirest.entity.UsuarioCliente;
import com.formacionspringboot.apirest.service.EmpleadoService;
import com.formacionspringboot.apirest.service.UsuarioClienteService;

@RestController
@RequestMapping("/api")
public class UsuarioClienteController {

	@Autowired
	UsuarioClienteService servicio;
	
	@PostMapping("/usuariocliente")
	public ResponseEntity<?> saveClienteExcepciones(@RequestBody UsuarioCliente usuarioCliente){
		
		Map<String,Object> response= new HashMap<>();
		
		
		UsuarioCliente usuario_peticion=servicio.findByNombreUsuario(usuarioCliente.getNombre());
		
		if(!(usuario_peticion==null)) {
			
			if(usuarioCliente.getPassword().equals(usuario_peticion.getPassword())) {
				response.put("mensaje", "El usuario "+usuario_peticion.getNombre()+" entra en la aplicacion");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
			}else {
				response.put("mensaje", "La contraseña del usuario "+usuario_peticion.getNombre()+" no es correcta");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
			}
			
		}else {
			
			response.put("mensaje", "No existe el usuario "+usuarioCliente.getNombre());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
			
		}
		

		
		
	}


	
	
}
