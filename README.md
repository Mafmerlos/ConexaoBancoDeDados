📋 Sistema de Cadastro de Pessoas
Aplicação Java baseada no padrão MVC que permite o cadastro, listagem, atualização e remoção de registros de pessoas, com persistência em banco de dados MySQL e interface gráfica via JOptionPane.

🚀 Funcionalidades
✅ Cadastro de pessoas com nome, CPF, RG, endereço e data de nascimento
✅ Listagem de todos os registros cadastrados
✅ Atualização dos dados de uma pessoa pelo ID
✅ Remoção de um cadastro pelo ID
✅ Interface simples e intuitiva com JOptionPane

🛠️ Estrutura do Projeto
graphql
Copiar
Editar
src/
└── main/
    └── java/
        └── org.example/
            ├── BancoDados/
            │   └── Conexao.java               # Para gerenciar a conexão com o banco
            ├── Constantes/
            │   └── ConstantePessoas.java      # Como o menu é fixo criei uma constante para ele 
            ├── Controller/
            │   └── PessoasController.java     # Coordena ações entre View e DAO
            ├── DAO/
            │   └── PessoasDAO.java            # Operações CRUD com banco de dados
            ├── Model/
            │   └── PessoasModel.java          # Representa a entidade Pessoa que foi utilizada
            ├── View/
            │   └── PessoasView.java           # Interação com o usuário (JOptionPane)
            └── Main.java                      # Ponto de entrada da aplicação

✅ Requisitos
* Java 8 ou superior
* MySQL instalado e em execução
* Driver JDBC do MySQL (adicionado ao classpath do projeto)

💡 Melhorias Futuras
🔄 Implementação completa do CRUD
🔐 Validações de entrada de dados
🔑 Login de usuários
🌐 Implementar versão web usando React no frontend
🔧 Criar API REST com Spring Boot para integração com frontend moderno

