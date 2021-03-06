package br.com.aluraflix.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aluraflix.exception.BadRequestException;
import br.com.aluraflix.exception.ResourceNotFoundException;
import br.com.aluraflix.model.Video;
import br.com.aluraflix.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository;

	public Video saveVideoRegister(Video video) {
		 
		try {
			Long categoria_id = video.getCategoria_id();
			if(categoria_id == null) {
				video.setCategoria_id(1L);
			}
			videoRepository.save(video);
		}
		catch(ConstraintViolationException e) {
			throw new BadRequestException(e.getMessage());
		}
		return video;
	}

	public List<Video> showAllVideoRegisters() {
		return  videoRepository.findAll();
		
	}
	
	public Video findVideoById(Long id){	
		return videoRepository.
				findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Video not found"));
		
	}
	public void deleteSpecificRegister(Long id){
		videoRepository.deleteById(id);
	 
	}
}
