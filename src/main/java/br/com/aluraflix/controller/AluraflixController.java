package br.com.aluraflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

}
