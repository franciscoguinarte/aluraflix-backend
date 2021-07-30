package br.com.aluraflix.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.aluraflix.exception.ResourceNotFoundException;
import br.com.aluraflix.model.Video;
import br.com.aluraflix.service.VideoService;

@RestController
@RequestMapping("/videos")
public class VideoController {

	@Autowired
	private VideoService videoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Video registerVideo(@RequestBody Video video) {

		return videoService.saveVideoRegister(video);
	}

	@GetMapping
	public List<Video> showAllRegisters() {
		return videoService.showAllVideoRegisters();
		 
	}

	@GetMapping("/{id}")
	public ResponseEntity<Video> showOneRegister(@PathVariable Long id) {

		Video res = videoService.findVideoById(id);
		return ResponseEntity.ok(res);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Video> remove(@PathVariable Long id) {

		videoService.findVideoById(id);
		videoService.deleteSpecificRegister(id);
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable Long id, @RequestBody Video video) {

		try {
			Video register = videoService.findVideoById(id);
			
			if(register != null) {
				BeanUtils.copyProperties(video, register,"id");
				
				register = videoService.saveVideoRegister(register);
				
				return ResponseEntity.ok(register);
			}
			
			return ResponseEntity.notFound().build();
		
		} catch (ResourceNotFoundException e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		 
	}

	
	@PatchMapping("/{id}")
	public ResponseEntity<?> partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> video) {

		video.forEach((nomePropriedade,valorPropriedade)->{
			
			System.out.println(video);
		});
		Video register = videoService.findVideoById(id);
		if(register == null) {
			
			return ResponseEntity.notFound().build();
		}
		merge(video, register);
 		return update(id, register);  
	}

	private void merge(Map<String, Object> originField, Video destinyField) {
			originField.forEach((propertyLabel,propertieValue)->{
				 Field field = ReflectionUtils.findField(Video.class, propertyLabel);
				 field.setAccessible(true);
				 
				 
				 ReflectionUtils.setField(field, destinyField, propertieValue);
			});
	}
}
