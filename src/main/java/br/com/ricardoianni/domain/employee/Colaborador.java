package br.com.ricardoianni.domain.employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import br.com.ricardoianni.domain.company.Empresa;
import br.com.ricardoianni.domain.holerite.Holerite;
import br.com.ricardoianni.domain.user.Usuario;
import br.com.ricardoianni.util.StringUtils;
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
	
	@Column(name = "CTPS")
	private String ctps;
	
	@Column(name = "serie_CTPS")
	private String serieCTPS;
	
	@Column(name = "PIS_PASEP")
	private String pisPasep;
	
	@Column(name = "CPF")
	private String cpf;
	
	private LocalDate dataNascimento;
	
	@OneToMany(mappedBy = "colaboradorCompetencia")
	private List<Competencia> competencias = new ArrayList<>();
	
	@OneToMany(mappedBy = "colaboradorHolerite")
	private List<Holerite> holerites = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "colaborador_empresa",
				joinColumns = @JoinColumn(name = "idcolaborador"),
				inverseJoinColumns = @JoinColumn(name = "idempresa") )
	private List<Empresa> empresasColaborador = new ArrayList<>(0);
	
	public void setDataNascimento(LocalDate data) {
		this.dataNascimento = data;
	}
	
	public void setDataNascimento(String data) {
		
		if (! StringUtils.isEmpty(data)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			this.dataNascimento = LocalDate.parse(data, formatter);
		}
	}
	
}
