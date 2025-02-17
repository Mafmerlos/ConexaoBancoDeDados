package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoMySQL {
    private static final String URL;
    private static final String USUARIO;
    private static final String SENHA;

    static {
        Properties prop = new Properties();
        try (InputStream input = ConexaoMySQL.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Arquivo config.properties não encontrado");
            }
            prop.load(input);
            URL = prop.getProperty("db.url");
            USUARIO = prop.getProperty("db.user");
            SENHA = prop.getProperty("db.password");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar configurações do banco de dados", e);
        }
    }

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        System.out.println("URL: " + URL);
        System.out.println("Usuário: " + USUARIO);
    }
}
