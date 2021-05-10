package com.fook.lexfirma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fook.lexfirma.model.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {
    List<Processo> findAllByUsuarioID(Long usuarioID);
    void deleteAllByUsuarioIDIs(Long usuarioID);
}
