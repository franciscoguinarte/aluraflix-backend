package br.com.aluraflix.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Video {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@NotNull
	@NotBlank
	@Size(max = 30)
	private String titulo;
	
	@NotEmpty
	@NotNull
	@NotBlank
	@Size(max = 90)
	private String descricao;

	@NotEmpty
	@NotNull
	@NotBlank
	@Size(max = 120)
	private String url;

}
