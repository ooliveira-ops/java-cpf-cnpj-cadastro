/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_queiroz_cpf_cnpj;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static Scanner leia = new Scanner(System.in);
    static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static void main(String[] args) {

        int opcao = 0;

        do {
            System.out.println("\n=== SISTEMA DE CADASTRO ===");
            System.out.println("1 - Cadastrar pessoa física");
            System.out.println("2 - Cadastrar pessoa jurídica");
            System.out.println("3 - Buscar por CPF ou CNPJ");
            System.out.println("4 - Listar todos os registros");
            System.out.println("5 - Encerrar");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(leia.nextLine());

                switch (opcao) {
                    case 1:
                        cadastrarPessoa(1);
                        break;

                    case 2:
                        cadastrarPessoa(2);
                        break;

                    case 3:
                        buscarPessoa();
                        break;

                    case 4:
                        listarPessoas();
                        break;

                    case 5:
                        exibirResumo();
                        System.out.println("Sistema encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida! Escolha de 1 a 5.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Entrada inválida: " + e.getMessage());
            }

        } while (opcao != 5);

        leia.close();
    }

    public static void cadastrarPessoa(int tipo) {

        System.out.print("Digite o nome: ");
        String nome = leia.nextLine();

        System.out.print("Digite o e-mail: ");
        String email = leia.nextLine();

        System.out.print(tipo == 1 
                ? "Digite o CPF: " 
                : "Digite o CNPJ: ");

        String numero = leia.nextLine();

        Documento documento;

        if (tipo == 1) {
            documento = new CPF(numero);
        } else {
            documento = new CNPJ(numero);
        }

        for (Pessoa pessoa : pessoas) {
            String existente = pessoa.getDocumento()
                    .getNumero().replaceAll("\\D", "");

            String informado = documento.getNumero()
                    .replaceAll("\\D", "");

            if (existente.equals(informado)) {
                System.out.println("Erro: documento já cadastrado!");
                return;
            }
        }

        Pessoa novaPessoa;

        if (tipo == 1) {
            novaPessoa = new PessoaFisica(nome, email, (CPF) documento);
        } else {
            novaPessoa = new PessoaJuridica(nome, email, (CNPJ) documento);
        }

        pessoas.add(novaPessoa);
        System.out.println("Cadastro realizado com sucesso!");
    }

    public static void buscarPessoa() {

        System.out.print("Digite o CPF ou CNPJ que deseja buscar: ");
        String numero = leia.nextLine().replaceAll("\\D", "");

        for (Pessoa pessoa : pessoas) {
            String existente = pessoa.getDocumento()
                    .getNumero().replaceAll("\\D", "");

            if (existente.equals(numero)) {
                System.out.println("\nRegistro encontrado:");
                pessoa.exibirDados();
                return;
            }
        }

        System.out.println("Nenhuma pessoa encontrada com esse documento.");
    }

    public static void listarPessoas() {

        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }

        System.out.println("\n=== TODOS OS REGISTROS ===");

        for (Pessoa pessoa : pessoas) {
            pessoa.exibirDados();
            System.out.println();
        }
    }
    public static void exibirResumo() {

        int total = pessoas.size();
        int fisicas = 0;
        int juridicas = 0;
        int documentosValidos = 0;

        for (Pessoa pessoa : pessoas) {

            if (pessoa instanceof PessoaFisica) {
                fisicas++;
            }

            if (pessoa instanceof PessoaJuridica) {
                juridicas++;
            }

            if (pessoa.getDocumento().validar()) {
                documentosValidos++;
            }
        }

        System.out.println("\n=== RESUMO FINAL ===");
        System.out.println("Total de pessoas: " + total);
        System.out.println("Pessoas físicas: " + fisicas);
        System.out.println("Pessoas jurídicas: " + juridicas);
        System.out.println("Documentos válidos: " + documentosValidos);
    }
}