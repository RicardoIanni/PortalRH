package br.com.ricardoianni.domain.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

	public Colaborador findByUsername(String username);
	
	public Colaborador findByIdColaborador(Integer idColaborador);

	public List<Colaborador> findByCpf(String cpf);
	
	public List<Colaborador> findByEmpresasColaborador_IdEmpresa(Integer idEmpresa);
	
	//TODO: Buscar por texto

}
