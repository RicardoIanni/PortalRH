package br.com.ricardoianni.domain.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.ricardoianni.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iduser")
	private Integer idUser;
	
	private String username;
	
	private String password;
	
	private String nickname;
	
	private String nome;
	
	private boolean master;
	
	private boolean adminstrator;
	
	public void encryptPassword() {
		this.password = StringUtils.encrypt(this.password);
	}
	
}
