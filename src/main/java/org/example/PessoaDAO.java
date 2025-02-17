package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PessoaDAO {
    public void inserirPessoa(String nome, String dataNascimento, String endereco, String cpf) {
        String sql = "INSERT INTO pessoas (nome, nascimento, endereco, cpf) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(dataNascimento, formatter);
            Date sqlDate = Date.valueOf(localDate);

            stmt.setString(1, nome);
            stmt.setDate(2, sqlDate);
            stmt.setString(3, endereco);
            stmt.setString(4, cpf);

            stmt.executeUpdate();
            System.out.println("Pessoa cadastrada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir pessoa: " + e.getMessage());
        }
    }
}
