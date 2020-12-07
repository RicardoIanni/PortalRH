package br.com.ricardoianni.infrastructure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ricardoianni.domain.employee.ColaboradorRepository;
import br.com.ricardoianni.domain.masteruser.MasterUserRepository;
import br.com.ricardoianni.domain.user.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private MasterUserRepository masterUserRepository;
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = masterUserRepository.findByUsername(username);
		
		if (usuario == null) {
			usuario = colaboradorRepository.findByUsername(username);
		}
		
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new LoggedUser(usuario);
	}

}
