package com.fook.lexfirma.model;

import java.util.Objects;

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

    @Column
    private Long usuarioID;

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

    public Long getUsuarioID() {
	return usuarioID;
    }

    public void setUsuarioID(Long usuario_id) {
	this.usuarioID = usuario_id;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	Pessoa pessoa = (Pessoa) o;
	return id.equals(pessoa.id);
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    @Override
    public String toString() {
	return "Pessoa{" + "id=" + id + ", nome='" + nome + '\'' + ", documento='" + documento + '\'' + ", contato='"
		+ contato + '\'' + ", usuario_id=" + usuarioID + '}';
    }
}
