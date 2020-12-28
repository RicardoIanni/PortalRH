package br.com.ricardoianni.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ricardoianni.domain.customer.Cliente;
import br.com.ricardoianni.domain.customer.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> clienteSearch() {
		return clienteRepository.findAll();
	}
	
	public List<Cliente> clienteSearch(String texto) {
		
		return clienteRepository.findByNomeContaining(texto);
	}
	
	@Transactional
	public void clienteSave(Cliente cliente) {
		clienteRepository.save(cliente);
	}
}
