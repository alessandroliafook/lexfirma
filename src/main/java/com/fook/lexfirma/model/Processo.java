//package com.fook.lexfirma.model;
//
//import javax.persistence.*;
//
//@Entity(name = "processo")
//@Table
//public class Processo {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column
//    private String numero;
//
//    @OneToOne
//    private Usuario usuario;
//
//    @OneToOne
//    private Pessoa autor;
//
//    @OneToOne
//    private Pessoa reu;
//
//    public Long getId() {
//	return id;
//    }
//
//    public void setId(Long id) {
//	this.id = id;
//    }
//
//    public String getNumero() {
//	return numero;
//    }
//
//    public void setNumero(String numero) {
//	this.numero = numero;
//    }
//
//    public Usuario getUsuario() {
//	return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//	this.usuario = usuario;
//    }
//
//    public Pessoa getAutor() {
//	return autor;
//    }
//
//    public void setAutor(Pessoa autor) {
//	this.autor = autor;
//    }
//
//    public Pessoa getReu() {
//	return reu;
//    }
//
//    public void setReu(Pessoa reu) {
//	this.reu = reu;
//    }
//
//    @Override
//    public String toString() {
//	return "Processo{" + "id=" + id + ", numero='" + numero + '\'' + ", usuario=" + usuario + ", autor=" + autor
//		+ ", reu=" + reu + '}';
//    }
//}
