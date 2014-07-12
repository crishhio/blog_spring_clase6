package org.upiita.spring.seguridad;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;


public class LoginFaliidoManejador extends SimpleUrlAuthenticationFailureHandler {
	 @Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 
		 Integer loginsFallidos= (Integer) request.getSession().getAttribute("loginsFallidos");
		 
		 if(loginsFallidos== null)
			 loginsFallidos=1;
		 else
			 loginsFallidos++;
		 request.getSession().getAttribute("loginsFallidos");
		super.onAuthenticationFailure(request, response, exception);
	}

}
