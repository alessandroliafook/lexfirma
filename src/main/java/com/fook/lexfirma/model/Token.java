package com.fook.lexfirma.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table
public class Token {
    private final int DIA_IN_MILISECONDS = 86400000;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String chave;
    @Column
    private Date expirationDate;
    @Column(unique = true)
    private Long usuarioId;

    public Token(Long usuarioId) {
	setExpirationDate(new Date());
	getExpirationDate().setTime(System.currentTimeMillis() + DIA_IN_MILISECONDS);
	setChave(UUID.randomUUID().toString());
	setUsuarioId(usuarioId);
    }

    public Token() {
    }

    public String getChave() {
	return chave;
    }

    public void setChave(String chave) {
	this.chave = chave;
    }

    public Date getExpirationDate() {
	return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
	this.expirationDate = expirationDate;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Long getUsuarioId() {
	return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
	this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
	return "Token{" + "id=" + id + ", chave='" + chave + '\'' + ", expirationDate=" + expirationDate
		+ ", usuarioId=" + usuarioId + '}';
    }
}
