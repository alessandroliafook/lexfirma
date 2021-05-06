package com.fook.lexfirma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fook.lexfirma.model.Pessoa;
import com.fook.lexfirma.repository.PessoaRepository;

@Component
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> getPessoas(Long usuarioId) {
	return pessoaRepository.findAllByUsuarioID(usuarioId);
    }

    public Pessoa addPessoa(Pessoa pessoa) {
	return pessoaRepository.save(pessoa);
    }

    public void removePessoa(Long id) {
	pessoaRepository.deleteById(id);
    }
}
