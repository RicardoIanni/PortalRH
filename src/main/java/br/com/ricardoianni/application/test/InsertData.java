package br.com.ricardoianni.application.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.ricardoianni.domain.endereco.Estado;
import br.com.ricardoianni.domain.endereco.EstadoRepository;
import br.com.ricardoianni.domain.usuario.Usuario;
import br.com.ricardoianni.domain.usuario.UsuarioRepository;
import br.com.ricardoianni.util.StringUtils;

@Component
public class InsertData {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		insertMasterUser();
		insertAllStates();
		
	}
	
	private void insertMasterUser() {
		List<Usuario> masterUsers = usuarioRepository.findByMasterTrue();
		
		if (masterUsers.size() == 0) {
			Usuario masterUser = new Usuario();
			
			masterUser.setUsername("hsolera");
			masterUser.setPassword(StringUtils.encrypt("hsf"));
			masterUser.setMaster(true);
			masterUser.setAdminstrator(false);
			
			usuarioRepository.save(masterUser);
		}
		
	}
	
	private void insertAllStates() {
		List<Estado> estados = estadoRepository.findAll();
		
		if (estados.size() == 0) {
			insertState("AC","Acre");
			insertState("AL","Alagoas");
			insertState("AP","Amapá");
			insertState("AM","Amazonas");
			insertState("BA","Bahia");
			insertState("CE","Ceará");
			insertState("DF","Distrito Federal");
			insertState("ES","Espirito Santo");
			insertState("GO","Goiás");
			insertState("MA","Maranhão");
			insertState("MT","Mato Grosso");
			insertState("MS","Mato Grosso do Sul");
			insertState("MG","Minas Gerais");
			insertState("PA","Pará");
			insertState("PB","Paraíba");
			insertState("PR","Parana");
			insertState("PE","Pernambuco");
			insertState("PI","Piauí");
			insertState("RJ","Rio de Janeiro");
			insertState("RN","Rio Grande do Norte");
			insertState("RS","Rio Grande do Sul");
			insertState("RO","Rondônia");
			insertState("RR","Roraima");
			insertState("SC","Santa Catarina");
			insertState("SP","São Paulo");
			insertState("SE","Sergipe");
			insertState("TO","Tocantins");
		}
	}
	
	private void insertState(String sigla, String nomeEstado) {
		Estado estado = new Estado();
		
		estado.setSigla(sigla);
		estado.setNomeEstado(nomeEstado);
		
		estadoRepository.save(estado);
	}
}