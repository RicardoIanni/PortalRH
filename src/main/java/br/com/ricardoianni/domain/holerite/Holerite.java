package br.com.ricardoianni.domain.holerite;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.ricardoianni.domain.company.Empresa;
import br.com.ricardoianni.domain.employee.Colaborador;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Entity
public class Holerite implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idholerite")
	private Integer idHolerite;
	
	private String mes;
	
	private String ano;
	
	private TipoRecibo tipoRecibo;
	
	private LocalDate dataAdmissao;
	
	public String getDataAdmissaoFormated() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));
		
		return dataAdmissao.format(formatter);
	}
	
	private String contrato;
	
	private String funcao;
	
	@Column(name = "CBO")
	private String cbo;
	
	private String departamento;
	
	private BigDecimal totalVencimento;
	
	private BigDecimal totalDesconto;
	
	private BigDecimal salarioLiquido;
	
	private BigDecimal salarioBase;
	
	@Column(name = "salario_INSS")
	private BigDecimal salarioINSS;
	
	@Column(name = "salario_FGTS")
	private BigDecimal salarioFGTS;
	
	@Column(name = "FGTS_mes")
	private BigDecimal fgtsMes;
	
	@Column(name = "salario_IRRF")
	private BigDecimal salarioIRRF;
	
	@Column(name = "faixa_IRRF")
	private BigDecimal faixaIRRF;
	
	@ManyToOne
	@JoinColumn(name = "idcolaborador")
	private Colaborador colaboradorHolerite;

	@ManyToOne
	@JoinColumn(name = "idempresa")
	private Empresa empresaHolerite;
	
	@OneToMany(mappedBy = "holeriteVencimento")
	private List<HoleriteVencimento> vencimentos = new ArrayList<>(0);
	
	@OneToMany(mappedBy = "holeriteDesconto")
	private List<HoleriteDesconto> descontos = new ArrayList<>(0);

}
