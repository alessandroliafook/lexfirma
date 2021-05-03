package com.fook.lexfirma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fook.lexfirma.model.Pessoa;
import com.fook.lexfirma.model.Usuario;
import com.fook.lexfirma.service.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public @ResponseBody Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
	return usuarioService.criarUsuario(usuario);
    }

    @RequestMapping(value = "/usuario/{email}", method = RequestMethod.GET)
    public @ResponseBody Usuario cadastrarUsuario(@PathVariable String email) {
	return usuarioService.logar(email);
    }

    @RequestMapping(value = "/pessoas/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Pessoa> cadastrarUsuario(@PathVariable Long id) {
	return usuarioService.getPessoas(id);
    }

    @RequestMapping(value = "/pessoas/{id}", method = RequestMethod.POST)
    public @ResponseBody Pessoa cadastrarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
	return usuarioService.addPessoa(id, pessoa);
    }
}
