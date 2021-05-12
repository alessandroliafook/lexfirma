package com.fook.lexfirma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fook.lexfirma.model.Usuario;
import com.fook.lexfirma.repository.UsuarioRepository;

@Component
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
	return usuarioRepository.save(usuario);
    }

    public Long logar(String email, String senha) {
	Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);
	if (usuario != null)
	    return usuario.getId();
	return new Long(-1);
    }

    public Usuario getUsuario(Long id) {
	return usuarioRepository.getOne(id);
    }

    public void deleteUsuario(Long id) {
	usuarioRepository.deleteById(id);
    }
}
