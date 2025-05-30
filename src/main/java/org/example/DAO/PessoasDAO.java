package org.example.DAO;

import org.example.BancoDados.Conexao;
import org.example.Model.PessoasModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoasDAO {
    private Conexao conexao = new Conexao();

    public void inserirPessoa(PessoasModel pessoas) {
        String sql = "INSERT INTO pessoas (nome, cpf, rg, endereco, data_nasc) VALUES (?,?,?,?,?)";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pessoas.getNome());
            stmt.setString(2, pessoas.getCpf());
            stmt.setString(3, pessoas.getRg());
            stmt.setString(4, pessoas.getEndereco());
            stmt.setString(5, pessoas.getDataNascimento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir", e);
        }
    }

    public List<PessoasModel> listarPessoa() {
        List<PessoasModel> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoas";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PessoasModel pessoasModel = new PessoasModel();
                pessoasModel.setId(rs.getInt("id"));
                pessoasModel.setNome(rs.getString("nome"));
                pessoasModel.setCpf(rs.getString("cpf"));
                pessoasModel.setRg(rs.getString("rg"));
                pessoasModel.setEndereco(rs.getString("endereco"));
                pessoasModel.setDataNascimento(rs.getString("data_nasc"));
                pessoas.add(pessoasModel);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar", e);
        }
        return pessoas;
    }

    public PessoasModel buscarPorId(int id) {
        String sql = "SELECT * FROM pessoas WHERE id = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    PessoasModel pessoasModel = new PessoasModel();
                    pessoasModel.setId(rs.getInt("id"));
                    pessoasModel.setNome(rs.getString("nome"));
                    pessoasModel.setCpf(rs.getString("cpf"));
                    pessoasModel.setRg(rs.getString("rg"));
                    pessoasModel.setEndereco(rs.getString("endereco"));
                    pessoasModel.setDataNascimento(rs.getString("data_nasc"));
                    return pessoasModel;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar pessoa por ID", e);
        }
        return null;
    }

    public void atualizarPessoa(PessoasModel pessoasModel) {
        String sql = "UPDATE pessoas SET nome = ?, cpf = ?, rg = ?, endereco = ?, data_nasc = ? WHERE id = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pessoasModel.getNome());
            stmt.setString(2, pessoasModel.getCpf());
            stmt.setString(3, pessoasModel.getRg());
            stmt.setString(4, pessoasModel.getEndereco());
            stmt.setString(5, pessoasModel.getDataNascimento());
            stmt.setInt(6, pessoasModel.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar", e);
        }
    }

    public void deletarPessoa(int id) {
        String sql = "DELETE FROM pessoas WHERE id = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar", e);
        }
    }
}
