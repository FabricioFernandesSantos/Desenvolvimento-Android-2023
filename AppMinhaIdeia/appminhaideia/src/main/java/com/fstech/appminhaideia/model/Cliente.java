package com.fstech.appminhaideia.model;

import com.fstech.appminhaideia.controller.ICrud;

public class Cliente {

    //atributos

    private int id;
    private String nome;
    private String email;
    private String telefone;
    private int idade;


    //construtor


    //métodos de acessos (getts e setts);


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }



}
