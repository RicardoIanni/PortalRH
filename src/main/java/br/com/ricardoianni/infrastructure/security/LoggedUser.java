package br.com.ricardoianni.infrastructure.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.ricardoianni.domain.employee.Colaborador;
import br.com.ricardoianni.domain.masteruser.MasterUser;
import br.com.ricardoianni.domain.user.Usuario;
import br.com.ricardoianni.util.CollectionUtils;

@SuppressWarnings("serial")
public class LoggedUser implements UserDetails {

	private Usuario user;
	private Role role;
	private Collection<? extends GrantedAuthority> roles;
	
	
	public LoggedUser(Usuario usuario) {
		this.user = usuario;
		
		Role role = Role.NOTHING;
		
		if (usuario instanceof MasterUser) {
			role = Role.MASTER;
		} 
		
		if (usuario instanceof Colaborador) {
			role = Role.EMPLOYEE;
		}
		
		this.role = role;
		this.roles = CollectionUtils.listOf(new SimpleGrantedAuthority("ROLE_" + role));
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public Role getRole() {
		return role;
	}
	
	public Usuario getUser() {
		return user;
	}

}