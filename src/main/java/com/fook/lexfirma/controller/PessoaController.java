package com.fook.lexfirma.controller;

import com.fook.lexfirma.model.Pessoa;
import com.fook.lexfirma.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario/{idUsuario}")
public class PessoaController {

		@Autowired
		private UsuarioService usuarioService;

		@RequestMapping(value = "/pessoas", method = RequestMethod.GET)
		public @ResponseBody List<Pessoa> listarPessoas(@PathVariable Long idUsuario) {
				return usuarioService.getPessoas(idUsuario);
		}

		@RequestMapping(value = "/pessoas", method = RequestMethod.POST)
		public @ResponseBody Pessoa cadastrarPessoa(@PathVariable Long idUsuario, @RequestBody Pessoa pessoa) {

				return usuarioService.addPessoa(idUsuario, pessoa);
		}

		@RequestMapping(value = "/pessoas/{id}", method = RequestMethod.DELETE)
		public void removerPessoa(@PathVariable Long idUsuario, @PathVariable Long id) {
				usuarioService.removerPessoa(idUsuario, id);
		}
}
