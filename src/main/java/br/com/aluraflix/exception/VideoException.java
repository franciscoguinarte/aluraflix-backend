package br.com.aluraflix.exception;

public class VideoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public VideoException(String message) {
		super(message);
	}
}
