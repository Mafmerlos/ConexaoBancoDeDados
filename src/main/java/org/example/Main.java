package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaDAO pessoaDAO = new PessoaDAO();

        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();

        System.out.println("Digite a data de nascimento (DD/MM/YYYY):");
        String dataNascimento = scanner.nextLine();

        System.out.println("Digite o endereço:");
        String endereco = scanner.nextLine();

        System.out.println("Digite o CPF:");
        String cpf = scanner.nextLine();

        pessoaDAO.inserirPessoa(nome, dataNascimento, endereco, cpf);
    }
}
