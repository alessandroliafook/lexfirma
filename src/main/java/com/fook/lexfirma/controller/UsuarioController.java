package com.fook.lexfirma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fook.lexfirma.model.Usuario;
import com.fook.lexfirma.service.PessoaService;
import com.fook.lexfirma.service.ProcessoService;
import com.fook.lexfirma.service.ReciboService;
import com.fook.lexfirma.service.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ProcessoService processoService;

    @Autowired
    private ReciboService reciboService;

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public @ResponseBody Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
	return usuarioService.criarUsuario(usuario);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public @ResponseBody Usuario getUsuario(@PathVariable Long id) {
	return usuarioService.getUsuario(id);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public void deleteUsuario(@PathVariable Long id) {
	usuarioService.deleteUsuario(id);
	pessoaService.delete(id);
	processoService.delete(id);
	reciboService.delete(id);
    }
}
