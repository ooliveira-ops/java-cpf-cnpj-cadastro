# Cadastro CPF/CNPJ

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apachenetbeanside&logoColor=white)
![POO](https://img.shields.io/badge/POO-Heran%C3%A7a%20%7C%20Polimorfismo-blue?style=for-the-badge)

> Sistema de cadastro de pessoas físicas e jurídicas em **Java**, com validação de CPF e CNPJ.
> Atividade da faculdade desenvolvida em grupo, baseada na **Lista Incremental IV — Java POO**.

---

## 🎯 O que é este projeto

Um sistema de console construído de forma **incremental** (10 incrementos), em que cada etapa transforma o programa anterior:
de uma simples classe `Pessoa` até um cadastro completo com menu, busca e resumo final.

**Funcionalidades:**

- Cadastrar pessoa física (CPF) e pessoa jurídica (CNPJ)
- Validar a estrutura e os dígitos verificadores dos documentos
- Impedir documentos duplicados
- Buscar por CPF ou CNPJ
- Listar todos os registros
- Exibir resumo final (total, físicas, jurídicas e documentos válidos)

---

## 🧱 Estrutura das classes

| Classe | Papel |
|---|---|
| `Documento` | Classe abstrata com `validar()` e `formatar()` |
| `CPF` / `CNPJ` | Subclasses de `Documento`, com regras próprias |
| `Pessoa` | Classe abstrata com nome, e-mail e um `Documento` |
| `PessoaFisica` / `PessoaJuridica` | Subclasses de `Pessoa`, com `exibirDados()` |
| `Principal` | Menu, entrada de dados e coleção `ArrayList<Pessoa>` |

**Conceitos de POO aplicados:** encapsulamento · composição · herança · classes abstratas · polimorfismo

---

## 🚀 Como executar

### Requisitos

| Item | Observação |
|---|---|
| [JDK 21](https://www.oracle.com/java/technologies/downloads/) | Versão definida no `pom.xml` |
| NetBeans, VS Code ou terminal | Qualquer um serve |

### Pelo terminal

```bash
javac -d target/classes src/main/java/com/mycompany/trabalho_queiroz_cpf_cnpj/*.java
java -cp target/classes com.mycompany.trabalho_queiroz_cpf_cnpj.Principal
```

### Pela IDE

Abra a pasta do projeto, localize a classe `Principal` e execute o método `main`.

---

## 📋 Menu do sistema

```text
=== SISTEMA DE CADASTRO ===
1 - Cadastrar pessoa física
2 - Cadastrar pessoa jurídica
3 - Buscar por CPF ou CNPJ
4 - Listar todos os registros
5 - Encerrar
```

---

<div align="center">

*Projeto acadêmico desenvolvido em grupo.*

</div>
