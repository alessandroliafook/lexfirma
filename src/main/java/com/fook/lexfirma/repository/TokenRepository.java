package com.fook.lexfirma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fook.lexfirma.model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByChave(String chave);

    Token findByUsuarioId(Long usuarioId);

    void deleteByUsuarioId(Long usuarioId);
}
