package org.example.Controller;

import org.example.DAO.PessoasDAO;
import org.example.Model.PessoasModel;
import org.example.View.PessoasView;

import javax.swing.*;
import java.util.List;

public class PessoasController {
    private PessoasDAO pessoasDAO = new PessoasDAO();
    private PessoasView pessoasView = new PessoasView();

    public void criarPessoa() {
        PessoasModel pessoasModel = pessoasView.solicitarDados();
        pessoasDAO.inserirPessoa(pessoasModel);
        JOptionPane.showMessageDialog(null, "Pessoa inserida com sucesso");
    }

    public void listarPessoa() {
        List<PessoasModel> pessoas = pessoasDAO.listarPessoa();
        mostrarPessoas(pessoas);
    }

    public void atualizarPessoa() {
        int id = pessoasView.solicitarIdParaAtualizar();
        PessoasModel pessoasModelExistente = pessoasDAO.buscarPorId(id);
        if (pessoasModelExistente == null) {
            pessoasView.mostrarMensagem("Pessoa com ID " + id + " não encontrada.");
            return;
        }

        PessoasModel pessoasModelAtualizado = pessoasView.solicitarDadosAtualizados(pessoasModelExistente);
        pessoasModelAtualizado.setId(id);
        pessoasDAO.atualizarPessoa(pessoasModelAtualizado);
        pessoasView.mostrarMensagem("Pessoa atualizada com sucesso!");
    }

    public void deletarPessoa() {
        int id = pessoasView.solicitarIdParaDeletar();
        if (id != -1) {
            pessoasDAO.deletarPessoa(id);
            pessoasView.mostrarMensagem("Pessoa deletada com sucesso!");
        }
    }

    public void mostrarPessoas(List<PessoasModel> pessoas) {
        StringBuilder sb = new StringBuilder();
        for (PessoasModel pessoa : pessoas) {
            sb.append("ID: ").append(pessoa.getId())
                    .append("\nNome: ").append(pessoa.getNome())
                    .append("\nCPF: ").append(pessoa.getCpf())
                    .append("\nRG: ").append(pessoa.getRg())
                    .append("\nEndereço: ").append(pessoa.getEndereco())
                    .append("\nData Nascimento: ").append(pessoa.getDataNascimento())
                    .append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Pessoas", JOptionPane.INFORMATION_MESSAGE);
    }
}
