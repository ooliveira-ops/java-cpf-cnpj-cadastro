package com.mycompany.trabalho_queiroz_cpf_cnpj;

import java.util.Scanner;

public abstract class Pessoa {

    private String nome;
    private String email;
    private Documento documento;

    public Pessoa(String nome, String email, Documento documento) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O e-mail não pode ser vazio.");
        }

        if (documento == null || !documento.validar()) {
            throw new IllegalArgumentException("Documento inválido.");
        }

        this.nome = nome;
        this.email = email;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setNome(String novoNome) {
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            this.nome = novoNome;
        } else {
            System.out.println("Erro: o nome não pode ser vazio.");
        }
    }

    public abstract void exibirDados();
}