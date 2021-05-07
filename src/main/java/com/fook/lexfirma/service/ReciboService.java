package com.fook.lexfirma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fook.lexfirma.model.Recibo;
import com.fook.lexfirma.repository.ReciboRepository;

@Component
public class ReciboService {

    @Autowired
    private ReciboRepository reciboRepository;

    public Recibo save(Recibo recibo) {
	return reciboRepository.save(recibo);
    }

    public List<Recibo> getProcessos(Long usuarioID) {
	return reciboRepository.findAllByUsuarioID(usuarioID);
    }

    public void deleteProcesso(Long id) {
	reciboRepository.deleteById(id);
    }
}
