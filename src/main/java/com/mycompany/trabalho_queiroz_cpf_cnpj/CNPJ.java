/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_queiroz_cpf_cnpj;

/**
 *
 * @author PC
 */
public class CNPJ extends Documento {

    public CNPJ(String numero) {        
        super(numero);        
        //envia esse valor para o construtor de Documento, 
        //que armazena o número no atributo privado.
    }

    private int calcularDigito(
        String cnpj, int quantidade, int[] pesos) {

        int soma = 0;

        for (int i = 0; i < quantidade; i++) {
            // "cnpj.charAt(i)" : Pega o caractere que está na posição (i)
            // " - '0'" : Converte o caractere numerico em seu valor inteiro
            int algarismo = cnpj.charAt(i) - '0';
            soma += algarismo * pesos[i];
        }

        int resto = soma % 11;

        if (resto < 2) {
            return 0;
        }

        return 11 - resto;
    }
   
    @Override
    public boolean validar() {
        String numero = getNumero();

    if (numero == null) {
            throw new IllegalArgumentException(
                "CNPJ não pode ser nulo."
            );
        }

        // Remove pontos, barras, traços e espaços.
        String cnpjLimpo = numero.replaceAll("[./\\-\\s]", "");

        // Verifica se possui exatamente 14 algarismos.
        if (!cnpjLimpo.matches("[0-9]{14}")) {
            throw new IllegalArgumentException(
                "CNPJ deve conter exatamente 14 algarismos."
            );
        }

        // Rejeita números com todos os algarismos iguais.
        if (cnpjLimpo.matches("([0-9])\\1{13}")) {
            throw new IllegalArgumentException(
                "CNPJ não pode ter todos os algarismos iguais."
            );
        }        
        
        //Ex: 1122233300018   02.834.047/0012-39
        //Multiplicando pelos pesos do vetor resulta em 102 (Nesse exemplo)
        int primeiroDigito = calcularDigito(
            cnpjLimpo, 12,
            // Vetor (pesos)
            new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2}
        );

        int segundoDigito = calcularDigito(
            cnpjLimpo, 13,
            new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2}
        );
        
        //Ex: 11222333000181
        int primeiroInformado = cnpjLimpo.charAt(12) - '0';
        int segundoInformado = cnpjLimpo.charAt(13) - '0';

        if (primeiroDigito != primeiroInformado ||
            segundoDigito != segundoInformado) {

            throw new IllegalArgumentException(
                "CNPJ inválido: dígitos verificadores incorretos."
            );        
        }
        return true;
    }

    

    @Override
    public String formatar() {
        String cnpj = getNumero().replaceAll("[./\\-\\s]", "");
   
    return cnpj.substring(0, 2) + "." +
           cnpj.substring(2, 5) + "." +
           cnpj.substring(5, 8) + "/" +
           cnpj.substring(8, 12) + "-" +
           cnpj.substring(12, 14);
    }
}
