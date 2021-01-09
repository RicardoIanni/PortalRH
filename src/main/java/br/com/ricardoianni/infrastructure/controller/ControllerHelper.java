package br.com.ricardoianni.infrastructure.controller;

import org.springframework.ui.Model;

import br.com.ricardoianni.domain.administrator.Administrador;
import br.com.ricardoianni.domain.employee.Colaborador;
import br.com.ricardoianni.domain.masteruser.MasterUser;
import br.com.ricardoianni.domain.user.Usuario;
import br.com.ricardoianni.util.SecurityUtils;

public class ControllerHelper {
	
	public static Usuario setLoggedUser(Model model) {
		Usuario usuario = SecurityUtils.getUsuario();

		if (usuario instanceof MasterUser) {
			model.addAttribute("bodyId", "Master");
		} else if (usuario instanceof Administrador) {
			model.addAttribute("bodyId", "Administrador");
		} else if (usuario instanceof Colaborador) {
			model.addAttribute("bodyId", "Colaborador");
		}
		
		model.addAttribute("usuario", usuario);
		
		return usuario;
	}

}
