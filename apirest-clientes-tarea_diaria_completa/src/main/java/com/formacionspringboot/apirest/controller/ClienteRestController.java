package com.formacionspringboot.apirest.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.formacionspringboot.apirest.dao.ClienteDao;
import com.formacionspringboot.apirest.entity.Cliente;
import com.formacionspringboot.apirest.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private ClienteService servicio;
	
	
	
	
	
	@GetMapping({"/clientes","/todos"})
	public List<Cliente> index(){
		
		return servicio.findAll();
		
	}	
	
	
	@GetMapping("/clientes/{id}")
	public Cliente findClienteById(@PathVariable Long id) {
		
		return servicio.findById(id);
	}
	
	
	
	@GetMapping("/clientes/excepciones/{id}")
	public ResponseEntity<?> findClienteByIdExcepciones(@PathVariable Long id){
		
		Cliente cliente=null;
		Map<String,Object> response= new HashMap<>();
		
		try {
			
			cliente=servicio.findById(id);
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al realizar consulta a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		if(cliente==null) {
			
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat("no existe en la base de datos")));
			
			return 	new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}
	
	
	

	
	
	
	/*OJO, HEMOS PUESTO QUE EL EMAIL ES UNIQUE, SI INTENTAMOS INSERTAR 
	 * DOS CLIENTES CON MISMO EMAIL NO NOS DEJARÁ
	 */
	@PostMapping("/cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente saveCliente(@RequestBody Cliente cliente) {
		
		return servicio.save(cliente);
	}
	
	@PostMapping("/cliente/excepciones")
	public ResponseEntity<?> saveClienteExcepciones(@RequestBody Cliente cliente){
		
		Cliente clienteNew=null;
		Map<String,Object> response= new HashMap<>();
		
		
		try {
			
			cliente=servicio.save(cliente);
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al realizar un insert a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "El cliente ha sido creado con éxito");
		response.put("cliente", clienteNew);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
		
		
		
	}
	
	
	
	/**
	 * 
	 * @param cliente recibimos el objeto cliente del body de la peticion POST
	 * @param id recogemos con este parametro el objeto del repositorio y le actualizamos los
	 * valores conforme al objeto del boyd de la peticion POST
	 * @return
	 */
	
	@PutMapping("/cliente/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
		
		Cliente clienteUpdate=servicio.findById(id);
		
		clienteUpdate.setNombre(cliente.getNombre());
		clienteUpdate.setApellido(cliente.getApellido());
		clienteUpdate.setEmail(cliente.getNombre());
		clienteUpdate.setTelefono(cliente.getTelefono());
		clienteUpdate.setCreatedAt(cliente.getCreatedAt());
		
		return servicio.save(clienteUpdate);
		
		
	}
	
	
	
	@PutMapping("/cliente/excepciones/{id}")
	public ResponseEntity<?> updateClienteExcepciones(@RequestBody Cliente cliente, @PathVariable Long id) {
	
		
		Map<String,Object> 	response = new HashMap<>();
		Cliente clienteActual=servicio.findById(id);
		
		if(clienteActual==null) {
			
			response.put("mensaje", "Error: no se pudo editar, el cliente con ID: "+id.toString()+"no existe en la BBDD");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			
		}
		

	try {	
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setEmail(cliente.getNombre());
		clienteActual.setTelefono(cliente.getTelefono());
		clienteActual.setCreatedAt(cliente.getCreatedAt());
		
		servicio.save(clienteActual);
		
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		response.put("mensaje", "Error al realizar un update a la base de datos");
		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	response.put("mensaje", "El cliente ha sido actualizado con éxito");
	response.put("cliente", clienteActual);
	
	return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
		
	}
	

	@DeleteMapping("/cliente/{id}")
	public void deleteCliente(@PathVariable Long id) {
		servicio.delete(id);
	}
	
	@DeleteMapping("/cliente/excepciones/{id}")
	public ResponseEntity<?> deleteClienteExcepciones(@PathVariable Long id) {
		Map<String,Object> 	response = new HashMap<>();
		Cliente clienteActual=servicio.findById(id);
		
		if(clienteActual==null) {
			
			response.put("mensaje", "Error: no se pudo editar, el cliente con ID: "+id.toString()+"no existe en la BBDD");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			
		}
		
		//Para borrar foto cuando borramos cliente
		try {	
		servicio.delete(id);
		String nombreFotoAnterior=clienteActual.getImagen();
		
		if(nombreFotoAnterior!=null && nombreFotoAnterior.length()>0) {
			
			Path rutaFotoAnterior=Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
			File archivoFotoAnterior=rutaFotoAnterior.toFile();
			
			if(archivoFotoAnterior.exists()&& archivoFotoAnterior.canRead()) {
				
				archivoFotoAnterior.delete();
			}
		} 
		
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al realizar un delete a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("cliente", clienteActual);
		response.put("mensaje", "Se ha borrado con exito el cliente");
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	/*
	 * Se asocia archivo a un id que ENVIAMOS por parametro en peticion POST
	 */
	@PostMapping("/cliente/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id  ){
		
		Map<String,Object> 	response = new HashMap<>();
		
		//obtengo el cliente que viene por la peticion POST	
		Cliente cliente=servicio.findById(id);
		
		//verifico que el archivo que viene por el POST no viene vacío
		if(!archivo.isEmpty()) {
			//capturo el nombre del archivo
			//String nombreArchivo=archivo.getOriginalFilename();
			
			
			
			//Para que al enviar el mismo archivo con el mismo nombre no sale error generamos una id para cada rchivo
			
			String nombreArchivo=UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
			//capturo la ruta del archivo
			Path rutaArchivo=Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
		
		
		try {
			//uNA VEZ TENEMOS EL ARCHIVO copiamos el archivo a nuestra carpeta uploads
			Files.copy(archivo.getInputStream(),rutaArchivo);
			
		}catch (IOException e) {
			
			response.put("mensaje", "Error al subir la imagen");
			response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
		
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		//Para evitar acumular imagenes
		String nombreFotoAnterior=cliente.getImagen();
		
		if(nombreFotoAnterior!=null && nombreFotoAnterior.length()>0) {
			
			Path rutaFotoAnterior=Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
			File archivoFotoAnterior=rutaFotoAnterior.toFile();
			
			if(archivoFotoAnterior.exists()&& archivoFotoAnterior.canRead()) {
				
				archivoFotoAnterior.delete();
			}
		} 
		
		//Una vez recuperado y guardado el archivo por la petición post, lo asignamos al cliente y guardamos
		cliente.setImagen(nombreArchivo);
		servicio.save(cliente);
		
		response.put("cliente", cliente);
		response.put("mensaje","Has subido correctamente la imagen: "+nombreArchivo);
		
		}	
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	
	//con .+ accedemos a la extensión de la imagen jpg, png, etc.
	@GetMapping("/upload/imagen/{nombreImagen:.+}")
	public ResponseEntity<Resource> verImagen(@PathVariable String nombreImagen){
		
Path rutaImagen = Paths.get("uploads").resolve(nombreImagen).toAbsolutePath();
		
		Resource recurso= null;
		
		try {
			
			recurso = new UrlResource(rutaImagen.toUri());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if(!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error no se puede cargar la imagen "+nombreImagen);
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\" "+recurso.getFilename()+"\"");
		
		return new ResponseEntity<Resource>(recurso,cabecera,HttpStatus.OK);
		
		
		//Spring no te deja acceder facilmente a un archivo
		//para acceder pasamos la cabecera por URL y que se descargue la imagen
		//otros frameworks te dejan abrir la imagen directamente de nuestra carpeta
		//Debemos probar esto en el navegador y no en postam, porque no esta configurado
		
		
	}
	
	
}
