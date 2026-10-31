package com.mycompany.trabalho_queiroz_cpf_cnpj;

public class CPF extends Documento{

        
    public CPF(String numero) {
        super(numero);
        validar();                
    }       
    
    @Override
    public boolean validar(){
        String numero = getNumero();
        
    if (numero == null) {
            throw new IllegalArgumentException(
                "CPF não pode ser nulo."
            );
        }
        
        // Remove pontos, traços e espaços.
        String cpfLimpo = numero.replaceAll("[.\\-\\s]", "");

        // Verifica se possui exatamente 11 algarismos.
        if (!cpfLimpo.matches("[0-9]{11}")) {
            throw new IllegalArgumentException(
                "CPF deve conter exatamente 11 algarismos."
            );
        }

        // Rejeita números com todos os algarismos iguais.
        if (cpfLimpo.matches("([0-9])\\1{10}")) {
            throw new IllegalArgumentException(
                "CPF não pode ter todos os algarismos iguais."
            );

        }        

        // Calcula os dois dígitos verificadores.

        int primeiroDigito = calcularDigito(cpfLimpo, 9, 10);
        int segundoDigito = calcularDigito(cpfLimpo, 10, 11);

        // Compara os dígitos calculados com os informados.
        int primeiroInformado = cpfLimpo.charAt(9) - '0';
        int segundoInformado = cpfLimpo.charAt(10) - '0';

        if (primeiroDigito != primeiroInformado || 
                segundoDigito != segundoInformado) {

            throw new IllegalArgumentException("CPF inválido: dígitos verificadores incorretos.");

        }    
        return true;    
    }
    
    private int calcularDigito(
        String cpf, int quantidade, int pesoInicial) {
        
        int soma = 0;

        // O laço for percorre os algarismos, 
        // multiplica cada um pelo peso correspondente 
        // e acumula os produtos na variável soma. 
        for (int i = 0; i < quantidade; i++) {

            int algarismo = cpf.charAt(i) - '0';
            int peso = pesoInicial - i;
            soma += algarismo * peso;

        }

        int resultado = (soma * 10) % 11;
        
        if (resultado == 10) {
            
            resultado = 0;

        }
        return resultado;
    }
     // getNumero() obtém o número armazenado nesse objeto.

    @Override
    //Esse método separa os algarismos e acrescenta os pontos e o traço.
    public String formatar() {        
        String cpf = getNumero().replaceAll("[.\\-\\s]", "");
    
    
    return cpf.substring(0, 3) + "." + 
           cpf.substring(3, 6) + "." +
           cpf.substring(6, 9) + "-" +
           cpf.substring(9, 11);
    }
}