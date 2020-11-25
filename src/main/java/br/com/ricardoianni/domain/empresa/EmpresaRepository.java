package br.com.ricardoianni.domain.empresa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

	public List<Empresa> findByCnpjContaining(String cnpj);
	
	public List<Empresa> findByRazaoSocialContaining(String razao);
	
}
