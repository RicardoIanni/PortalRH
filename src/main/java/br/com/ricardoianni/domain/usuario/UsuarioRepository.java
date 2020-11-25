package br.com.ricardoianni.domain.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByUsername(String username);
	
	public List<Usuario> findByMasterTrue();
	
}
