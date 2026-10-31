package com.mycompany.trabalho_queiroz_cpf_cnpj;

public class PessoaJuridica extends Pessoa{

    public PessoaJuridica(String nome, String email, CNPJ cnpj) {
        super(nome, email, cnpj);
    }

    @Override
    public void exibirDados() {
        System.out.println("=== PESSOA JURÍDICA ===");
        System.out.println("Nome: " + getNome());
        System.out.println("E-mail: " + getEmail());
        System.out.println("CNPJ: " + getDocumento().formatar());
    }
    
}