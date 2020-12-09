package br.com.ricardoianni.domain.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	public List<Cliente> findByNomeContaining(String nome);
	
	public Cliente findByIdCliente(Integer idCliente);
	
}
