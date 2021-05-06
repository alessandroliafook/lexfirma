package com.fook.lexfirma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fook.lexfirma.model.Processo;
import com.fook.lexfirma.repository.ProcessoRepository;

@Component
public class ProcessoService {

    @Autowired
    private ProcessoRepository processoRepository;

    public Processo save(Processo processo) {
	return processoRepository.save(processo);
    }

    public List<Processo> getProcessos(Long usuarioID) {
	return processoRepository.findAllByUsuarioID(usuarioID);
    }

    public void deleteProcesso(Long id) {
	processoRepository.deleteById(id);
    }
}
