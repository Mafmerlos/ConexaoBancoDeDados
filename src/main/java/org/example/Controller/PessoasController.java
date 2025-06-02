package org.example.Controller;

import org.example.DAO.PessoasDAO;
import org.example.Model.PessoasModel;
import org.example.View.PessoasView;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;
import java.util.List;

public class PessoasController {
    private PessoasDAO pessoasDAO = new PessoasDAO();
    private PessoasView pessoasView = new PessoasView();

    public void criarPessoa() {
        PessoasModel pessoasModel;
        while (true) {
            pessoasModel = pessoasView.solicitarDados();
            if (validarDataNascimento(pessoasModel.getDataNascimento())) {
                break;
            } else {
                pessoasView.mostrarMensagem("Data de nascimento inválida. Formato deve ser YYYY-MM-DD, não pode estar no futuro e a pessoa deve ter pelo menos 18 anos.");
            }
        }
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

        PessoasModel pessoasModelAtualizado;
        while (true) {
            pessoasModelAtualizado = pessoasView.solicitarDadosAtualizados(pessoasModelExistente);
            if (validarDataNascimento(pessoasModelAtualizado.getDataNascimento())) {
                break;
            } else {
                pessoasView.mostrarMensagem("Data de nascimento inválida. Formato deve ser YYYY-MM-DD, não pode estar no futuro e a pessoa deve ter pelo menos 18 anos.");
            }
        }
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

    private boolean validarDataNascimento(String dataNascimento) {
        try {
            LocalDate data = LocalDate.parse(dataNascimento, DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate hoje = LocalDate.now();

            if (data.isAfter(hoje)) {
                return false;
            }

            int idade = Period.between(data, hoje).getYears();
            return idade >= 18;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
