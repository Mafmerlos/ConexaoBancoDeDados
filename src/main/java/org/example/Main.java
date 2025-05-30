package org.example;
import org.example.Constantes.ConstantePessoas;
import org.example.Controller.PessoasController;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        PessoasController pessoasController = new PessoasController();
        int opcao = 0;

        while (opcao != 5) {
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(ConstantePessoas.MENU));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Digite um número.");
                continue;
            }
            switch (opcao) {
                case 1: pessoasController.criarPessoa(); break;
                case 2: pessoasController.listarPessoa(); break;
                case 3: pessoasController.atualizarPessoa(); break;
                case 4: pessoasController.deletarPessoa(); break;
                case 5: JOptionPane.showMessageDialog(null, "Programa finalizado!"); break;
                default: JOptionPane.showMessageDialog(null, "Opção inválida"); break;
            }
        }
    }
}
