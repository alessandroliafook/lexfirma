package com.fook.lexfirma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fook.lexfirma.model.Recibo;
import com.fook.lexfirma.service.ReciboService;

@RestController
public class ReciboController {

    @Autowired
    private ReciboService reciboService;

    @RequestMapping(value = "/recibo", method = RequestMethod.POST)
    public @ResponseBody Recibo cadastrarProcesso(@RequestBody Recibo recibo) {
	return reciboService.save(recibo);
    }

    @RequestMapping(value = "/recibos/{usuarioID}", method = RequestMethod.GET)
    public @ResponseBody List<Recibo> recuperarProcessos(@PathVariable Long usuarioID) {
	return reciboService.getProcessos(usuarioID);
    }

    @RequestMapping(value = "/recibo/{id}", method = RequestMethod.DELETE)
    public void deletarProcesso(@PathVariable Long id) {
	reciboService.deleteProcesso(id);
    }
}
