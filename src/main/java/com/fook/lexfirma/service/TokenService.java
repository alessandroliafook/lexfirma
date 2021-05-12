package com.fook.lexfirma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fook.lexfirma.model.Token;
import com.fook.lexfirma.repository.TokenRepository;

@Component
public class TokenService {
    @Autowired
    TokenRepository repository;

    public Token getTokenByChave(String chave) {
	return repository.findByChave(chave);
    }

    public Token gerarToken(Long usuarioId) {
	Token token = repository.findByUsuarioId(usuarioId);
	if (token != null) repository.delete(token);
	return repository.save(new Token(usuarioId));
    }
}
