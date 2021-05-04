//package com.fook.lexfirma.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.fook.lexfirma.model.Processo;
//import com.fook.lexfirma.service.ProcessoService;
//import com.fook.lexfirma.service.UsuarioService;
//
//@RestController
//public class ProcessoController {
//
//    @Autowired
//    private ProcessoService processoService;
//
//    @Autowired
//    private UsuarioService usuarioService;
//
//    @RequestMapping(value = "/processo/{id}", method = RequestMethod.POST)
//    public @ResponseBody Processo cadastrarProcesso(@RequestBody Processo processo, @PathVariable Long id) {
//	Processo processoSalvo = processoService.save(processo);
//	usuarioService.addProcesso(processoSalvo, id);
//	return processoSalvo;
//    }
//
//    @RequestMapping(value = "/processo/{id}", method = RequestMethod.GET)
//    public @ResponseBody List<Processo> cadastrarProcesso(@PathVariable Long id) {
//	List<Processo> processos = usuarioService.getProcessos(id);
//	return processos;
//    }
//}
