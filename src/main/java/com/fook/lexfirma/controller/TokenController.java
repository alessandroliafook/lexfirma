package com.fook.lexfirma.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fook.lexfirma.model.Token;
import com.fook.lexfirma.service.TokenService;
import com.fook.lexfirma.service.UsuarioService;

@RestController
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Token login(@RequestBody Map<String, Object> userMap) {
	String email = (String) userMap.get("email");
	String senha = (String) userMap.get("senha");
	Long usuarioId = usuarioService.logar(email, senha);
	if (usuarioId > 0)
	    return tokenService.gerarToken(usuarioId);
	else
	    return null;
    }
}
