package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "alumnos")
public class Alumno {
	@Id
	private Integer dni;
	private String nombre;
	private String apellido;
	private String email;
	private Long telefono;
	private LocalDate fechaNac;
	private String domicilio;
	private Integer lu;
	@ManyToOne
    @JoinColumn(name = "carrera_id")
	   private Carrera carrera;
	@ManyToMany
    @JoinTable(name = "alumno_materia",
               joinColumns = @JoinColumn(name = "alumno_id"),
               inverseJoinColumns = @JoinColumn(name = "materia_id"))
    private Set<Materia> materias = new HashSet<>();
}
