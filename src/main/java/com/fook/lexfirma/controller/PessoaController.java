package com.fook.lexfirma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fook.lexfirma.model.Pessoa;
import com.fook.lexfirma.service.PessoaService;

@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(value = "/pessoas/{idUsuario}", method = RequestMethod.GET)
    public @ResponseBody List<Pessoa> listarPessoas(@PathVariable Long idUsuario) {
	return pessoaService.getPessoas(idUsuario);
    }

    @RequestMapping(value = "/pessoas", method = RequestMethod.POST)
    public @ResponseBody Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
	return pessoaService.addPessoa(pessoa);
    }

    @RequestMapping(value = "/pessoas/{id}", method = RequestMethod.DELETE)
    public void removerPessoa(@PathVariable Long id) {
	pessoaService.removePessoa(id);
    }
}
