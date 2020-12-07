package br.com.ricardoianni.domain.user;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import br.com.ricardoianni.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@MappedSuperclass
public class Usuario implements Serializable {

	private String username;
	
	private String password;
	
	private String nickname;
	
	private String nome;
	
	public void encryptPassword() {
		this.password = StringUtils.encrypt(this.password);
	}
	
}
