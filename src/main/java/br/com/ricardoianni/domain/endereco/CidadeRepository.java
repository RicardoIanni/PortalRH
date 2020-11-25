package br.com.ricardoianni.domain.endereco;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	public List<Cidade> findByEstadoCidade(Estado estado);
	
	public List<Cidade> findByEstadoCidadeAndNomeCidadeContaining(Estado estado, String nomeCidade);
	
	public List<Cidade> findByNomeCidadeContaining(String nomeCidade);
	
}
