package com.fook.lexfirma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fook.lexfirma.model.Processo;
import com.fook.lexfirma.service.ProcessoService;
import com.fook.lexfirma.service.UsuarioService;

@RestController
public class ProcessoController {

    @Autowired
    private ProcessoService processoService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/processo", method = RequestMethod.POST)
    public @ResponseBody Processo cadastrarProcesso(@RequestBody Processo processo) {
	return processoService.save(processo);
    }

    @RequestMapping(value = "/processos/{usuarioID}", method = RequestMethod.GET)
    public @ResponseBody List<Processo> recuperarProcessos(@PathVariable Long usuarioID) {
	return processoService.getProcessos(usuarioID);
    }

    @RequestMapping(value = "/processo/{id}", method = RequestMethod.DELETE)
    public void deletarProcesso(@PathVariable Long id) {
	processoService.deleteProcesso(id);
    }
}
