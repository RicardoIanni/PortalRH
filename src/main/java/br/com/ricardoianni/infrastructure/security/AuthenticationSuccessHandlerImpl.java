package br.com.ricardoianni.infrastructure.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import br.com.ricardoianni.util.SecurityUtils;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		Role role = SecurityUtils.loggedUser().getRole();
		
		if (role == Role.MASTER) {
			response.sendRedirect("master/home");
		} else if (role == Role.ADMINISTRATOR) {
			response.sendRedirect("admin/home");
		} else if (role == Role.EMPLOYEE) {
			response.sendRedirect("colab/home");
		} else {
			throw new IllegalStateException("Erro na autenticação");
		}
		
	}

}
