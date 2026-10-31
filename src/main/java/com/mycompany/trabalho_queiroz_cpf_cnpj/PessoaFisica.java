package com.mycompany.trabalho_queiroz_cpf_cnpj;

public class PessoaFisica extends Pessoa{

    public PessoaFisica(String nome, String email, CPF cpf) {
        super(nome, email, cpf);
    }

    @Override
    public void exibirDados() {
        System.out.println("=== PESSOA FÍSICA ===");
        System.out.println("Nome: " + getNome());
        System.out.println("E-mail: " + getEmail());
        System.out.println("CPF: " + getDocumento().formatar());
    }
    
}