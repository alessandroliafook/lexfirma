package com.fook.lexfirma.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fook.lexfirma.model.Token;
import com.fook.lexfirma.service.TokenService;

@Component
@Order(1)
public class TransactionFilter implements Filter {

    @Autowired
    TokenService tokenService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {

	HttpServletRequest req = (HttpServletRequest) request;
	if (!req.getRequestURI().contains("/login") && !req.getRequestURI().contains(".")
		&& !req.getRequestURI().equals("/")) {
	    Token token = tokenService.getTokenByChave(req.getHeader("token"));
	    if (token == null || token.getExpirationDate().before(new Date()))
		((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
			"The token is not valid.");
	}

	chain.doFilter(request, response);
    }
}
