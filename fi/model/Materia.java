package ar.edu.unju.fi.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer codigo;
	private String nombre;
	private String curso;
	private Byte cantHoras;
	private Boolean modalidad;
	private Boolean estado;
	
	@ManyToMany(mappedBy = "materias")
	private Set<Alumno> alumnos = new HashSet<>();
	@Autowired
	private Docente docente;
	@Autowired
	private Carrera carrera;
}
