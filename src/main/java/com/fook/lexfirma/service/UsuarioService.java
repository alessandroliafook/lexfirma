package com.fook.lexfirma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fook.lexfirma.model.Usuario;
import com.fook.lexfirma.repository.UsuarioRepository;

//import com.fook.lexfirma.model.Processo;

@Component
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
	return usuarioRepository.save(usuario);
    }

    public Long logar(String email) {
	Usuario usuario = usuarioRepository.findByEmail(email);
	if (usuario != null)
	    return usuario.getId();
	return new Long(-1);
    }
}
