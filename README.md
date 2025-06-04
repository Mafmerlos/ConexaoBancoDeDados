# 📋 Sistema de Cadastro de Pessoas

Aplicação Java baseada no padrão **MVC** que permite o cadastro, listagem, atualização e remoção de registros de pessoas, com persistência em banco de dados **MySQL** e interface gráfica via `JOptionPane`.

---

## 🚀 Funcionalidades

- ✅ Cadastro de pessoas com nome, CPF, RG, endereço e data de nascimento  
- ✅ Listagem de todos os registros cadastrados  
- ✅ Atualização dos dados de uma pessoa pelo ID  
- ✅ Remoção de um cadastro pelo ID  
- ✅ Interface simples e intuitiva com `JOptionPane`

---

## 🛠️ Estrutura do Projeto

```
src/
└── main/
    └── java/
        └── org.example/
            ├── BancoDados/
            │   └── Conexao.java               # Gerenciar a conexão com o banco de dados 
            ├── Constantes/
            │   └── ConstantePessoas.java      # Armazenar o menu (por ser fixo)
            ├── Controller/
            │   └── PessoasController.java     # Coordena as ações entre View e DAO
            ├── DAO/
            │   └── PessoasDAO.java            # Responsável pelas operações CRUD com o banco
            ├── Model/
            │   └── PessoasModel.java          # Representa a entidade Pessoa utilizada no projeto até o momento
            ├── View/
            │   └── PessoasView.java           # Interface com o usuário (via JOptionPane)
            └── Main.java                      # Ponto de entrada da aplicação
```

---

## ✅ Requisitos

-   Java 8 ou superior  
-   MySQL instalado e em execução  
-   Driver JDBC do MySQL adicionado ao classpath do projeto

---

## 💡 Melhorias Futuras

-  Implementação completa do CRUD  
-  Validações de entrada de dados  
-  Login de usuários  
-  Implementar versão web usando **React** no frontend  
-  Criar API REST com **Spring Boot** para integração com frontend moderno

---
