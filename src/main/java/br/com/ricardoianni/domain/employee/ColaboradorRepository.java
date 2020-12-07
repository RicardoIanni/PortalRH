package br.com.ricardoianni.domain.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

	public Colaborador findByUsername(String username);
	
	public Colaborador findByIdFunc(String idFunc);

}
