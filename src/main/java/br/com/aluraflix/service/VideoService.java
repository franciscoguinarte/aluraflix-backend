package br.com.aluraflix.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.aluraflix.exception.BadRequestException;
import br.com.aluraflix.exception.VideoException;
import br.com.aluraflix.exception.VideoNotFoundException;
import br.com.aluraflix.model.Video;
import br.com.aluraflix.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository;

	public Video saveVideoRegister(Video video) {

		try {
			videoRepository.save(video);
		}
		catch(ConstraintViolationException e) {
			throw new BadRequestException(e.getMessage());
		}
		return video;
	}

	public List<Video> showAllVideoRegisters() {
		return videoRepository.findAll();
	}
	
	public Video findVideoById(Long id){	
		return videoRepository.
				findById(id).
				orElseThrow(()-> new VideoNotFoundException("Video not found"));
		
	}
	public void deleteSpecificRegister(Long id){
		videoRepository.deleteById(id);
	 
	}
}
