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

import br.com.ricardoianni.domain.empresa.Empresa;
import br.com.ricardoianni.domain.endereco.Endereco;
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

	@Column(name = "idfunc")
	private String idFunc;
	
	private String mes;
	
	private String ano;
	
	private String nome;
	
	private String ctps;
	
	private String serieCTPS;
	
	private String pis_pasep;
	
	private String cpf;
	
	private LocalDate dataAdmissao;
	
	public String getDataAdmissaoFormated() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));
		
		return dataAdmissao.format(formatter);
	}
	
	private String contrato;
	
	private String funcao;
	
	private String cbo;
	
	private String departamento;
	
	private BigDecimal totalVencimento;
	
	private BigDecimal totalDesconto;
	
	private BigDecimal salarioLiquido;
	
	private BigDecimal salarioBase;
	
	private BigDecimal salarioINSS;
	
	private BigDecimal salarioFGTS;
	
	private BigDecimal fgtsMes;
	
	private BigDecimal salarioIRRF;
	
	private BigDecimal faixaIRRF;
	
	@ManyToOne
	@JoinColumn(name = "idempresa")
	private Empresa empresaHolerite;
	
	@ManyToOne
	@JoinColumn(name = "idendereco")
	private Endereco enderecoHolerite;

	@OneToMany(mappedBy = "holeriteVencimento")
	private List<HoleriteVencimento> vencimentos = new ArrayList<>(0);
	
	@OneToMany(mappedBy = "holeriteDesconto")
	private List<HoleriteDesconto> descontos = new ArrayList<>(0);

}
