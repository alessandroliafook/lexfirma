package com.fook.lexfirma.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "usuario")
@Table
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer", "fieldHandler" })
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @Email
    @NotBlank(message = "O email não pode ser vazio!")
    private String email;

    @Column
    @NotBlank(message = "O nome não pode ser vazio!")
    private String nome;

    @Column
    @NotBlank(message = "O documento não pode ser vazio!")
    private String documento;

    @Column
    @NotBlank(message = "A senha não pode ser vazio!")
    private String senha;

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

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    @Override
    public String toString() {
	return "Usuario{" + "id=" + id + ", email='" + email + '\'' + ", nome='" + nome + '\'' + ", documento='"
		+ documento + '\'' + '}';
    }
}
