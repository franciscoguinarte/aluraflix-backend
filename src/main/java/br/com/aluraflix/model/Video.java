package br.com.aluraflix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "videos", schema = "aluraflix")
public class Video {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 
	@Column(columnDefinition = "bigint default 1")
	private Long categoria_id;
 
	@NotBlank
	private String titulo;

	@NotBlank
	private String descricao;

	@NotBlank
	private String url;

}
