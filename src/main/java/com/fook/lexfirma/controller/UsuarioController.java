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
    public @ResponseBody Long login(@PathVariable String email) {
	return usuarioService.logar(email);
    }
}
