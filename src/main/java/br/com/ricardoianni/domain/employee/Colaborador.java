package br.com.ricardoianni.domain.employee;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.ricardoianni.domain.holerite.Holerite;
import br.com.ricardoianni.domain.user.Usuario;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
public class Colaborador extends Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcolaborador")
	private Integer idColaborador;
	
	@Column(name = "idfunc")
	private String idFunc;
	
	private String ctps;
	
	private String serieCTPS;
	
	private String pisPasep;
	
	private String cpf;
	
	@OneToMany(mappedBy = "colaboradorCompetencia")
	private List<Competencia> competencias = new ArrayList<>();
	
	@OneToMany(mappedBy = "colaboradorHolerite")
	private List<Holerite> holerites = new ArrayList<>();
	
}
