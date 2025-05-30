package org.example.View;
import org.example.Model.PessoasModel;
import javax.swing.*;

public class PessoasView {
    public PessoasModel solicitarDados() {
        String nome = JOptionPane.showInputDialog("Digite o nome: ");
        String cpf = JOptionPane.showInputDialog("Digite o CPF: ");
        String rg = JOptionPane.showInputDialog("Digite o RG: ");
        String endereco = JOptionPane.showInputDialog("Digite o endereço: ");
        String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento (ANO-MES-DIA): ");
        return PessoasModel.builder()
                .nome(nome)
                .cpf(cpf)
                .rg(rg)
                .endereco(endereco)
                .dataNascimento(dataNascimento)
                .build();
    }

    public int solicitarIdParaDeletar() {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog("Digite o ID a ser deletado:"));
        } catch (NumberFormatException e) {
            mostrarMensagem("ID inválido.");
            return -1;
        }
    }

    public int solicitarIdParaAtualizar() {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da pessoa a ser atualizada:"));
        } catch (NumberFormatException e) {
            mostrarMensagem("ID inválido.");
            return -1;
        }
    }

    public PessoasModel solicitarDadosAtualizados(PessoasModel pessoasModelAtual) {
        String nome = JOptionPane.showInputDialog("Nome atual: " + pessoasModelAtual.getNome()
                + "\nNovo nome:", pessoasModelAtual.getNome());
        String cpf = JOptionPane.showInputDialog("CPF atual: " + pessoasModelAtual.getCpf()
                + "\nNovo CPF:", pessoasModelAtual.getCpf());
        String rg = JOptionPane.showInputDialog("RG atual: " + pessoasModelAtual.getRg()
                + "\nNovo RG:", pessoasModelAtual.getRg());
        String endereco = JOptionPane.showInputDialog("Endereço atual: " + pessoasModelAtual.getEndereco()
                + "\nNovo endereço:", pessoasModelAtual.getEndereco());
        String dataNascimento = JOptionPane.showInputDialog("Data de nascimento atual: " + pessoasModelAtual.getDataNascimento()
                + "\nNova data de nascimento (YYYY-MM-DD):", pessoasModelAtual.getDataNascimento());

        return new PessoasModel(pessoasModelAtual.getId(), nome, cpf, rg, endereco, dataNascimento);
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
