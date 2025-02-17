# Sistema de Cadastro de Pessoas

Este projeto consiste em um sistema simples de cadastro de pessoas utilizando Java e MySQL. Ele permite o cadastro de informações como nome, data de nascimento, endereço e CPF de indivíduos em um banco de dados.

## Funcionalidades

- **Cadastro de Pessoa**: Permite inserir dados de uma pessoa no banco de dados.
- **Validação de CPF**: Verifica se o CPF informado possui o formato correto (simples, sem validação completa de CPF).
- **Conexão com MySQL**: Conecta-se ao banco de dados MySQL utilizando as credenciais armazenadas em um arquivo de configuração `config.properties`.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **MySQL**: Banco de dados para armazenamento de informações.
- **JDBC**: API do Java para conectar-se ao banco de dados MySQL.

## Melhorias Futuras

Este projeto está em desenvolvimento, e futuras melhorias estão planejadas, incluindo:

- **Regras de Negócio**: Implementação de regras de negócio, como a validação completa do CPF (verificando se é válido de acordo com o cálculo dos dígitos verificadores).
- **Validação de Dados**: Melhorias nas validações de entrada, como garantir que os campos não estejam vazios, que a data de nascimento seja válida e que o endereço tenha um formato apropriado.
- **Interface Gráfica**: Desenvolvimento de uma interface gráfica (GUI) para tornar a interação com o usuário mais intuitiva e fácil de usar.
- **Tratamento de Exceções**: Implementação de um melhor tratamento de exceções para lidar com erros de entrada e problemas na conexão com o banco de dados de forma mais amigável ao usuário.
- **Testes Unitários**: Criação de testes unitários para garantir que as funcionalidades do sistema funcionem corretamente em diferentes cenários.

## Licença

Este projeto é licenciado sob a MIT License. Para mais detalhes, consulte o arquivo [LICENSE](LICENSE).

---

Feito por [Matheus Figueira Merlos](https://github.com/Mafmerlos)

