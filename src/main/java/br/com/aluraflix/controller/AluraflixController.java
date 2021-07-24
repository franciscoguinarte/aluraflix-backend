package br.com.aluraflix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import br.com.aluraflix.model.Video;
import br.com.aluraflix.service.VideoService;

@RestController
@RequestMapping("/videos")
public class AluraflixController {

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
	public ResponseEntity<Video> removeOneRegister(@PathVariable Long id) {

		videoService.findVideoById(id);
		videoService.deleteSpecificRegister(id);
		return ResponseEntity.noContent().build();

	}

	@PatchMapping("/{id}")
	public ResponseEntity<Video> updatePartOfRegister(@Valid @PathVariable Long id, @RequestBody Video video) {

		videoService.findVideoById(id);
		video.setId(id);
		video = videoService.saveVideoRegister(video);
		return ResponseEntity.ok(video);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Video> updateRegister(@PathVariable Long id, @RequestBody Video video) {

		videoService.findVideoById(id);
		video.setId(id);
		video = videoService.saveVideoRegister(video);
		return ResponseEntity.ok(video);
	}

}
