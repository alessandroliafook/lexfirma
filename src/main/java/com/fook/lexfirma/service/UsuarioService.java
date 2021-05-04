package com.fook.lexfirma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fook.lexfirma.model.Pessoa;
//import com.fook.lexfirma.model.Processo;
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
	usuario.addPessoa(pessoa);

	return usuarioRepository.save(usuario);
    }

    public Usuario logar(String email) {
	return usuarioRepository.findByEmail(email);
    }

    public List<Pessoa> getPessoas(Long id) {
	return usuarioRepository.getOne(id).getPessoas();
    }

    public Pessoa addPessoa(Long id, Pessoa pessoa) {
	Pessoa pessoaSalva = pessoaRepository.save(pessoa);

	Usuario usuario = usuarioRepository.getOne(id);
	if (!usuario.getPessoas().contains(pessoa)) {
	    usuario.getPessoas().add(pessoa);
	    usuarioRepository.save(usuario);
	}

	return pessoaSalva;
    }

//    public void addProcesso(Processo processo, Long id) {
//	Usuario usuario = usuarioRepository.getOne(id);
//	usuario.getProcessos().add(processo);
//	usuarioRepository.save(usuario);
//    }

//    public List<Processo> getProcessos(Long id) {
//	return usuarioRepository.getOne(id).getProcessos();
//    }
}
