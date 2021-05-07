package com.fook.lexfirma.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity(name = "recibo")
@Table
public class Recibo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private float valor;
    @Column
    private Date vencimento;
    @Column
    private Long titularID;
    @Column
    private Long processoID;
    @Column
    private boolean pago;
    @Column
    private Long usuarioID;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public float getValor() {
	return valor;
    }

    public void setValor(float valor) {
	this.valor = valor;
    }

    public Date getVencimento() {
	return vencimento;
    }

    public void setVencimento(Date vencimento) {
	this.vencimento = vencimento;
    }

    public Long getTitularID() {
	return titularID;
    }

    public void setTitularID(Long titularID) {
	this.titularID = titularID;
    }

    public Long getProcessoID() {
	return processoID;
    }

    public void setProcessoID(Long processoID) {
	this.processoID = processoID;
    }

    public boolean isPago() {
	return pago;
    }

    public void setPago(boolean pago) {
	this.pago = pago;
    }

    public Long getUsuarioID() {
	return usuarioID;
    }

    public void setUsuarioID(Long usuarioID) {
	this.usuarioID = usuarioID;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	Recibo recibo = (Recibo) o;
	return Objects.equals(id, recibo.id);
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    @Override
    public String toString() {
	return "Recibo{" + "id=" + id + ", valor=" + valor + ", vencimento=" + vencimento + ", titularID=" + titularID
		+ ", processoID='" + processoID + '\'' + ", pago=" + pago + ", usuarioID=" + usuarioID + '}';
    }
}
