package com.fook.lexfirma.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity(name = "processo")
@Table
public class Processo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String numero;

    @Column
    private Long usuarioID;

    @Column
    private Long clientID;

    @Column
    private Date inicio;

    @Column
    private Date fim;

    @Column
    private float valorDaCausa;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNumero() {
	return numero;
    }

    public void setNumero(String numero) {
	this.numero = numero;
    }

    public Long getUsuarioID() {
	return usuarioID;
    }

    public void setUsuarioID(Long usuarioID) {
	this.usuarioID = usuarioID;
    }

    public Long getClientID() {
	return clientID;
    }

    public void setClientID(Long clientID) {
	this.clientID = clientID;
    }

    public Date getInicio() {
	return inicio;
    }

    public void setInicio(Date inicio) {
	this.inicio = inicio;
    }

    public Date getFim() {
	return fim;
    }

    public void setFim(Date fim) {
	this.fim = fim;
    }

    public float getValorDaCausa() {
	return valorDaCausa;
    }

    public void setValorDaCausa(float valorDaCausa) {
	this.valorDaCausa = valorDaCausa;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	Processo processo = (Processo) o;
	return Objects.equals(id, processo.id);
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    @Override
    public String toString() {
	return "Processo{" + "id=" + id + ", numero='" + numero + '\'' + ", usuarioID=" + usuarioID + ", clientID="
		+ clientID + ", inicio=" + inicio + ", fim=" + fim + ", valorDaCausa=" + valorDaCausa + '}';
    }
}
