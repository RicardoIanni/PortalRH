package br.com.ricardoianni.domain.company;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ricardoianni.domain.customer.Cliente;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

	public Empresa findByIdEmpresa(Integer idEmpresa);
	
	public List<Empresa> findByCnpjContaining(String cnpj);
	
	public List<Empresa> findByRazaoSocialContaining(String razaoSocial);
	
	public List<Empresa> findByClienteEmpresa(Cliente clienteEmpresa);
	
}
