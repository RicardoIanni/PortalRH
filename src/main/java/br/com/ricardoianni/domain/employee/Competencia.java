package br.com.ricardoianni.domain.employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.ricardoianni.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
public class Competencia implements Serializable {

	@Id
	@Column(name = "idcompetencia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompetencia;
	
	private String mes;
	
	private String ano;
	
	@ManyToOne
	@JoinColumn(name = "idcolaborador")
	private Colaborador colaboradorCompetencia;
	
	@OneToMany(mappedBy = "competenciaRecibo")
	private List<Recibo> recibos = new ArrayList<>();
	
	public String getRecibosAsText() {
		List<String> strings = new LinkedList<>();
		
		for (Recibo recibo : recibos) {
			strings.add(recibo.getTipoRecibo().name());
		}
		
		return StringUtils.concatenate(strings);
	}
}
