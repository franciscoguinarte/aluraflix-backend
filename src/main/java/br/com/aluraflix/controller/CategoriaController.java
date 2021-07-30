package br.com.aluraflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.aluraflix.model.Categoria;
import br.com.aluraflix.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

 	@GetMapping
	public List<Categoria> showAllRegisters() {
		return categoriaService.showAllCategoriasRegisters();

	}

 	@GetMapping("/{id}")
	public Categoria showOneRegister(@PathVariable Long id) {
		return categoriaService.findCategoriaById(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void createCategoriaRegister(@RequestBody Categoria categoria) {
		categoriaService.saveCategoriaRegister(categoria);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSpecificRegister(@PathVariable Long id) {
				categoriaService.deleteCategoria(id);
	}
	
 
}
