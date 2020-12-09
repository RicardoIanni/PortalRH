package br.com.ricardoianni.domain.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.ricardoianni.domain.company.Empresa;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
public class Cliente implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcliente")
	private Integer idCliente;
	
	private String nome;
	
	@Column(name = "customerID")
	private String customerID;
	
	private String username;
	
	private String password;
	
	private String endpoint;
	
	@OneToMany(mappedBy = "clienteEmpresa")
	private List<Empresa> empresas = new ArrayList<>();
	
}
