package ar.edu.unju.fi.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "carreras")
public class Carrera {
	@Id
	@GeneratedValue
	private Integer codigo;
	private String nombre;
	private Byte cantAnios;
	private Boolean estado;	
	
	@OneToMany(mappedBy = "carrera")
    private Set<Alumno> alumnos = new HashSet<>();
	
	@OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Materia> materias;
}
