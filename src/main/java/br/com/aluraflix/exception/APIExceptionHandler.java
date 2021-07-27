package br.com.aluraflix.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {
 	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleNegocio(ResourceNotFoundException ex, WebRequest request) {

		var status = HttpStatus.NOT_FOUND;
		var problem = new Problem();
		problem.setStatus(status.value());
		problem.setTitle(ex.getMessage());
		problem.setDateTime(LocalDateTime.now());

		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Object> handleBadRequest(BadRequestException ex, WebRequest request) {

		var status = HttpStatus.BAD_REQUEST;
		var problem = new Problem();
		problem.setStatus(status.value());
		problem.setTitle(ex.getMessage());
		problem.setDateTime(LocalDateTime.now());

		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
}
//
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//		
//		HttpHeaders headers, HttpStatus status, WebRequest request) {
//		
//		var campos = new ArrayList<Problem.Field>();
//		
//		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
//			String name = ((FieldError) error).getField();
//			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
//			
//			campos.add(new Problem.Field(name, message));
//			
//			
//		}
//		
//		var problem = new Problem ();
//		problem.setStatus(status.value());
//		problem.setTitle("Um ou mais campos invalidos");
//		// TODO Auto-generated method stub
//		problem.setDateTime(LocalDateTime.now());
//		problem.setFields(campos);
//		
//		return super.handleExceptionInternal(ex, problem, headers, status, request);
//}
//}
