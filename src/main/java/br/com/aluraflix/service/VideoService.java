package br.com.aluraflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aluraflix.exception.VideoException;
import br.com.aluraflix.model.Video;
import br.com.aluraflix.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository;

	public Video saveVideoRegister(Video video) {

		return videoRepository.save(video);

	}

	public List<Video> showAllVideoRegisters() {
		return videoRepository.findAll();
	}
	
	public Video showSpecificVideoRegister(Long id){
		
		Optional<Video> res = videoRepository.findById(id);
		
		if(res.isPresent()) {
			return res.get();
		}
		else {
			throw new VideoException("Invalid Register");
		}
	}
	public void deleteSpecificRegister(Long id){
		videoRepository.deleteById(id);
	 
	}
}
