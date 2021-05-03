package com.fook.lexfirma.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.relational.core.mapping.Table;

@Entity(name = "Usuario")
@Table
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @Email
    @NotBlank(message = "O email não pode ser vazio!")
    private String email;

    @OneToOne
    private Pessoa pessoa;

    @OneToMany
    private List<Pessoa> pessoas;

    @OneToMany
    private List<Processo> processos;

    Usuario() {
	this.pessoas = new ArrayList<>();
	this.processos = new ArrayList<>();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Pessoa getPessoa() {
	return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
	this.pessoa = pessoa;
    }

    public void addPessoa(Pessoa pessoa) {
	this.pessoas.add(pessoa);
    }

    public List<Pessoa> getPessoas() {
	return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
	this.pessoas = pessoas;
    }

    public List<Processo> getProcessos() {
	return processos;
    }

    public void setProcessos(List<Processo> processos) {
	this.processos = processos;
    }

    @Override
    public String toString() {
	return "Usuario{" + "id=" + id + ", email='" + email + '\'' + ", pessoa=" + pessoa + '}';
    }
}
