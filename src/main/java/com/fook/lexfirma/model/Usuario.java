package com.fook.lexfirma.model;

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

    @Override
    public String toString() {
	return "Usuario{" + "id=" + id + ", email='" + email + '\'' + ", pessoa=" + pessoa + '}';
    }
}
