package br.com.aluraflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aluraflix.model.Categoria;
import br.com.aluraflix.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
 
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<?> showAllRegisters(){
		ResponseEntity<?> res = categoriaService.showAllCategoriasRegisters();
		
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("/{id}")
	public Categoria showOneRegister(@PathVariable Long id) {
		return categoriaService.findCategoriaById(id);
	}


	 
}
