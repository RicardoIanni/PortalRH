package br.com.ricardoianni.domain.address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	public Endereco findByLogradouroAndNumeroAndComplementoAndBairroAndCidadeEndereco(String logradouro, 
																							String numero, 
																							String complemento, 
																							String bairro, 
																							Cidade cidadeEndereco);
}
