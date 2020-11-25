package br.com.ricardoianni.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricardoianni.domain.empresa.Empresa;
import br.com.ricardoianni.domain.empresa.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public List<Empresa> empresaSearch(String texto) {
		List<Empresa> empresas = new ArrayList<>();
		List<Empresa> empresasCNPJ = empresaRepository.findByCnpjContaining(texto);
		List<Empresa> empresasRazao = empresaRepository.findByRazaoSocialContaining(texto);

		if (empresasCNPJ.size() > 0) {
			empresas.addAll(empresasCNPJ);
		}
		
		if (empresasRazao.size() > 0) {
			empresas.addAll(empresasRazao);
		}
		
		return empresas;
	}
	
	public void empresaSalvar(Empresa empresa) {
		empresaRepository.save(empresa);
	}
}
