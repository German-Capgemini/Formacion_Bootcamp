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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionspringboot.apirest.entity.Cliente;
import com.formacionspringboot.apirest.entity.Producto;
import com.formacionspringboot.apirest.service.ClienteService;
import com.formacionspringboot.apirest.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoRestController {

	@Autowired
	private ProductoService servicio;
	
	@GetMapping("/productos")
	public List<Producto> index(){
		
		return servicio.findAll();
		
	}

	@GetMapping("/productos/{id}")
	public Producto findProductoById(@PathVariable Long id) {
		
		return servicio.findById(id);
	}
	
	@GetMapping("/productos/excepciones/{id}")
	public ResponseEntity<?> findProductoByIdExcepciones(@PathVariable Long id){
		
		Producto producto=null;
		Map<String,Object> response= new HashMap<>();
		
		try {
			
			producto=servicio.findById(id);
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al realizar consulta a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		if(producto==null) {
			
			response.put("mensaje", "El producto ID: ".concat(id.toString().concat("no existe en la base de datos")));
			
			return 	new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Producto>(producto,HttpStatus.OK);
	}

	@PostMapping("/producto")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto saveProducto(@RequestBody Producto producto) {
		
		return servicio.save(producto);
	}

	@PostMapping("/producto/excepciones")
	public ResponseEntity<?> saveProductoExcepciones(@RequestBody Producto producto){
		
		Producto productoNew=null;
		Map<String,Object> response= new HashMap<>();
		
		
		try {
			
			producto=servicio.save(producto);
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al realizar un insert a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "El producto ha sido creado con éxito");
		response.put("cliente", productoNew);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
		
		
		
	}

	@PutMapping("/producto/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto updateCliente(@RequestBody Producto producto, @PathVariable Long id) {
		
		Producto productoUpdate=servicio.findById(id);
		
		productoUpdate.setCantidad(producto.getCantidad());
		productoUpdate.setDescripcion(producto.getDescripcion());
		productoUpdate.setFecha_ingreso(producto.getFecha_ingreso());
		productoUpdate.setMarca(producto.getMarca());
		productoUpdate.setPrecio(producto.getPrecio());
		productoUpdate.setTipo(producto.getTipo());
		
		return servicio.save(productoUpdate);
		
		
	}

	@PutMapping("/producto/excepciones/{id}")
	public ResponseEntity<?> updateProductoExcepciones(@RequestBody Producto producto, @PathVariable Long id) {
	
		
		Map<String,Object> 	response = new HashMap<>();
		Producto productoUpdate=servicio.findById(id);
		
		if(productoUpdate==null) {
			
			response.put("mensaje", "Error: no se pudo editar, el producto con ID: "+id.toString()+"no existe en la BBDD");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			
		}
		

	try {	
		productoUpdate.setCantidad(producto.getCantidad());
		productoUpdate.setDescripcion(producto.getDescripcion());
		productoUpdate.setFecha_ingreso(producto.getFecha_ingreso());
		productoUpdate.setMarca(producto.getMarca());
		productoUpdate.setPrecio(producto.getPrecio());
		productoUpdate.setTipo(producto.getTipo());
		
		servicio.save(productoUpdate);
		
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		response.put("mensaje", "Error al realizar un update a la base de datos");
		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	response.put("mensaje", "El producto ha sido actualizado con éxito");
	response.put("producto", productoUpdate);
	
	return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
		
	}

	
	@DeleteMapping("/producto/{id}")
	public void deleteProducto(@PathVariable Long id) {
		servicio.delete(id);
	}
	
	
	@DeleteMapping("/producto/excepciones/{id}")
	public ResponseEntity<?> deleteProductoExcepciones(@PathVariable Long id) {
		Map<String,Object> 	response = new HashMap<>();
		Producto productoActual=servicio.findById(id);
		
		if(productoActual==null) {
			
			response.put("mensaje", "Error: no se pudo editar, el producto con ID: "+id.toString()+"no existe en la BBDD");
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
		
		response.put("producto", productoActual);
		response.put("mensaje", "Se ha borrado con exito el producto");
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	
	
	

}
