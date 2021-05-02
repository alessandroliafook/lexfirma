package com.fook.lexfirma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fook.lexfirma.model.Pessoa;
import com.fook.lexfirma.model.Usuario;
import com.fook.lexfirma.repository.PessoaRepository;
import com.fook.lexfirma.repository.UsuarioRepository;

@Component
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Usuario criarUsuario(Usuario usuario) {
	Pessoa pessoa = pessoaRepository.save(usuario.getPessoa());
	usuario.setPessoa(pessoa);
	return usuarioRepository.save(usuario);
    }

    public Usuario logar(String email) {
	return usuarioRepository.findByEmail(email);
    }
}
