package br.com.ricardoianni.domain.address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

	public Estado findBySigla(String sigla);
	
	public List<Estado> findByNomeEstadoContaining(String nomeEstado);
}
