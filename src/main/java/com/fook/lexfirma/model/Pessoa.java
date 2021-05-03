package com.fook.lexfirma.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "pessoa")
@Table
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotBlank(message = "O nome não pode ser vazio!")
    private String nome;

    @Column
    @NotBlank(message = "O documento não pode ser vazio!")
    private String documento;

    @Column
    private String contato;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getDocumento() {
	return documento;
    }

    public void setDocumento(String documento) {
	this.documento = documento;
    }

    public String getContato() {
	return contato;
    }

    public void setContato(String contato) {
	this.contato = contato;
    }

    @Override
    public String toString() {
	return "Pessoa{" + "id=" + id + ", nome='" + nome + '\'' + ", documento='" + documento + '\'' + ", contato='"
		+ contato + '\'' + '}';
    }
}
