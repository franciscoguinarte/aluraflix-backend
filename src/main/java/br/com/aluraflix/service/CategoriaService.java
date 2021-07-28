package br.com.aluraflix.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.aluraflix.exception.BadRequestException;
import br.com.aluraflix.exception.ResourceNotFoundException;
import br.com.aluraflix.model.Categoria;
import br.com.aluraflix.repository.CategoriaRepository;

@Service
public class CategoriaService {

	 @Autowired
	 private CategoriaRepository categoriaRepository;
	 
	 
	 public Categoria saveCategoriaRegister(Categoria categoria) {
		 
			try {
				categoriaRepository.save(categoria);
			}
			catch(ConstraintViolationException e) {
				throw new BadRequestException(e.getMessage());
			}
			return categoria;
	}
	 
	 public List<Categoria>  showAllCategoriasRegisters() {
		 
		 return categoriaRepository.findAll();
		 
	 }
	 
	 public Categoria findCategoriaById(Long id) {
		 
		 return categoriaRepository.findById(id).orElseThrow(
				 ()-> new ResourceNotFoundException("Categoria not found"));
	 }
	 
	 public void deleteCategoria(Long id) {
		 findCategoriaById(id);
		 categoriaRepository.deleteById(id);
	 }

	public ResponseEntity<Categoria> updateCategoria(Long id, Categoria categoria) {
		
		categoria.setId(id);
		
		categoriaRepository.save(categoria);
		Categoria res = findCategoriaById(id);
		
		return ResponseEntity.ok(res);
	}
	 
 
	 
	 
	 
}
