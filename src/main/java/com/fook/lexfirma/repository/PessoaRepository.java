package com.fook.lexfirma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fook.lexfirma.model.Pessoa;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
		List<Pessoa> findAllByUsuarioID(Long usuarioID);
}
