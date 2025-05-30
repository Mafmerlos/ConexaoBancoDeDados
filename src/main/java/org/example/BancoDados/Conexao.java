package org.example.BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    String url = "jdbc:mysql://localhost:3306/pessoas?serverTimezone=UTC";
    String user = "SEU USUARIO";
    String password = "SUA SENHA";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar no banco de dados", e);
        }
    }
}
