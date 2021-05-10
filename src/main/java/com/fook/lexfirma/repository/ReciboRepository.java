package com.fook.lexfirma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fook.lexfirma.model.Recibo;

public interface ReciboRepository extends JpaRepository<Recibo, Long> {
    List<Recibo> findAllByUsuarioID(Long usuarioID);
    void deleteAllByUsuarioIDIs(Long usuarioID);
}