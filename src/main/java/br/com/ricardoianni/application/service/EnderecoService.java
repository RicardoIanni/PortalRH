package br.com.ricardoianni.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricardoianni.domain.endereco.Cidade;
import br.com.ricardoianni.domain.endereco.CidadeRepository;
import br.com.ricardoianni.domain.endereco.Endereco;
import br.com.ricardoianni.domain.endereco.EnderecoRepository;
import br.com.ricardoianni.domain.endereco.Estado;
import br.com.ricardoianni.domain.endereco.EstadoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<Estado> estadoSearch() {
		
		return estadoRepository.findAll();
	}
	
	public List<Estado> estadoSearch(String sigla) {
		List<Estado> estados = new ArrayList<>();
		estados.add(estadoRepository.findBySigla(sigla));
				
		return estados;
	}
	
	public List<Estado> estadoSearch(String sigla, String nomeEstado) {
		List<Estado> estados = new ArrayList<>();
		
		if (sigla == null && nomeEstado == null) {
			return estadoSearch();
		} 
		
		if (sigla == null && nomeEstado != null) {
			return estadoRepository.findByNomeEstadoContaining(nomeEstado);
		}
		
		if (sigla != null) {
			return estadoSearch(sigla);
		}
		
		return estados;
	}
	
	public List<Cidade> cidadeSearch() {
		return cidadeRepository.findAll();
	}
	
	public List<Cidade> cidadeSearch(Estado estado) {
		if (estado == null) {
			return cidadeSearch();
		}
		
		return cidadeRepository.findByEstadoCidade(estado);
	}
	
	public List<Cidade> cidadeSearch(String nomeCidade) {
		if (nomeCidade == null) {
			return cidadeSearch();
		}
		
		return cidadeRepository.findByNomeCidadeContaining(nomeCidade);
	}
	
	public List<Cidade> cidadeSearch(Estado estado, String nomeCidade) {
		
		if (estado == null && nomeCidade == null) {
			return cidadeSearch();
		}
		
		if (estado == null && nomeCidade != null) {
			return cidadeSearch(nomeCidade);
		}
		
		if (estado != null && nomeCidade == null) {
			return cidadeSearch(estado);
		}
		
		return cidadeRepository.findByEstadoCidadeAndNomeCidadeContaining(estado, nomeCidade);
	}
	
	public List<Cidade> cidadeSearch(String sigla, String nomeCidade) {
		
		if (sigla == null && nomeCidade == null) {
			return cidadeSearch();
		}
		
		if (sigla == null && nomeCidade != null) {
			return cidadeSearch(nomeCidade);
		}
		
		Estado estado = estadoRepository.findBySigla(sigla);
		
		if (sigla != null && nomeCidade == null) {
			return cidadeSearch(estado);
		}
		
		return cidadeRepository.findByEstadoCidadeAndNomeCidadeContaining(estado, nomeCidade);
	}
	
	public void cidadeSalvar(Cidade cidade) {
		cidadeRepository.save(cidade);
	}
	
	public List<Endereco> enderecoSearch() {
		return enderecoRepository.findAll();
	}
	
	public List<Endereco> enderecoSearch(Cidade cidade) {
		return List.of();
	}
	
	public List<Endereco> enderecoSearch(Estado estado) {
		return List.of();
	}
	
	public List<Endereco> enderecoSearch(String logradouro, String numero, String complemento, String bairro, Cidade cidade) {
		if (logradouro == null && numero == null && complemento == null && bairro == null && cidade != null) {
			return enderecoSearch(cidade);
		}
		
		return enderecoRepository.findByLogradouroAndNumeroAndComplementoAndBairroAndCidadeEndereco(logradouro, numero, complemento, bairro, cidade);
	}
	
	public void enderecoSalvar(Endereco endereco) {
		enderecoRepository.save(endereco);
	}
	
}
