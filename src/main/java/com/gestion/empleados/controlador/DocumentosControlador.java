package com.gestion.empleados.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.modelo.Documentos;
import com.gestion.empleados.repositorio.DocumentosRepositorio;
import com.gestion.empleados.excepciones.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentosControlador {
	@Autowired
	private DocumentosRepositorio repositorio;

	@GetMapping("/documentos")
	@ResponseBody
	public List<Documentos> listarTodosLosDocumentos() {
		return repositorio.findAll();
	}
	
	@PostMapping("/documentos")
	public Documentos guardarDocumentos(@RequestBody Documentos documento) {
		return repositorio.save(documento);
	}
	
	@GetMapping("/documentos/{id}")
	public ResponseEntity<Documentos> obtenerDocumentoPorId(@PathVariable Long id){
		Documentos documento = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el documento con el id: " + id));
		return ResponseEntity.ok(documento);
	}
	
	@PutMapping("/documentos/{id}")
	public ResponseEntity<Documentos> actualizarDocumento(@PathVariable Long id, @RequestBody Documentos detallesDocumento){
		Documentos documento = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el documento con el id: " + id));
		
		documento.setDescripcion(detallesDocumento.getDescripcion());
		
		Documentos documentoActualizado = repositorio.save(documento);

		return ResponseEntity.ok(documentoActualizado);
	}
	
	@DeleteMapping("/documentos/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarDocumento(@PathVariable Long id){
		Documentos documento = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el documento con el ID : " + id));
		
		repositorio.delete(documento);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}
