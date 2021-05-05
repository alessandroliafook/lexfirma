package com.fook.lexfirma.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fook.lexfirma.model.Pessoa;
import com.fook.lexfirma.model.Usuario;
import com.fook.lexfirma.repository.PessoaRepository;
import com.fook.lexfirma.repository.UsuarioRepository;

//import com.fook.lexfirma.model.Processo;

@Component
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Usuario criarUsuario(Usuario usuario) {

	Pessoa pessoa = pessoaRepository.save(usuario.getPessoa());
	usuario.setPessoa(pessoa);
	usuario.addPessoa(pessoa);

	return usuarioRepository.save(usuario);
    }

    public Long logar(String email) {
	Usuario usuario = usuarioRepository.findByEmail(email);
	if (usuario != null)
	    return usuario.getId();
	return new Long(-1);
    }

    public List<Pessoa> getPessoas(Long idUsuario) {
	return usuarioRepository.getOne(idUsuario).getPessoas();
    }

    @Transactional
    public Pessoa addPessoa(Long idUsuario, Pessoa pessoa) {

	Pessoa pessoaSalva = pessoaRepository.save(pessoa);

	Usuario usuario = usuarioRepository.getOne(idUsuario);
	if (!usuario.getPessoas().contains(pessoa)) {
	    usuario.getPessoas().add(pessoa);
	    usuarioRepository.save(usuario);
	}

	return pessoaSalva;
    }

    public void removerPessoa(Long idUsuario, Long id) {
	Usuario usuario = usuarioRepository.getOne(idUsuario);
	System.out.println(usuario);
	Pessoa pessoa = pessoaRepository.getOne(id);
	usuario.getPessoas().remove(pessoa);
	usuario = usuarioRepository.save(usuario);
	System.out.println(usuario);
	pessoa = pessoaRepository.getOne(id);
	pessoaRepository.delete(pessoa);
    }
}
