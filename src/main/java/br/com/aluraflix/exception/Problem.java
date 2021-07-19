package br.com.aluraflix.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problem {
	private Integer status;
	private LocalDateTime dateTime;
	private String title;
	private List<Field> fields;
	
	public static class Field	{
		private String name;
		private String message;
		
		public String getName() {
			return name;
		}
		public Field(String name, String message) {
			super();
			this.name = name;
			this.message = message;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMessage () {
			return message;
		}
		public void setMensagem(String message) {
			this.message = message;
		}
		
	}
	
	
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
