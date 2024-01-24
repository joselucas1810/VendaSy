#language: pt


@cliente
Funcionalidade: Gravar Cliente
  Como um usuário
  Eu quero gravar um cliente no banco de dados
  Para garantir que o método salvarClienteDAO funcione corretamente

  Cenário: Gravar um novo cliente no sistema
    Dado que eu tenha um cliente com os seguintes dados:
      | Nome       | Endereço | Bairro   | Cidade   | UF | CEP       | Telefone       |
      | Cliente A  | Rua A    | Eldorado | Contagem | MG | 000000000 | 3199999999    |
    Quando eu gravar o cliente no banco de dados
    Então a operação de gravação deve ser bem-sucedida

@login
Funcionalidade: Validação do Login do Usuário
  Como um usuário
  Eu quero validar o login no sistema
  Para garantir que o método getValidarUsuarioDAO funcione corretamente

  Cenário: Validar o login com credenciais corretas
    Dado que tenho um usuário com login "jose.gouveia.est@samarco.com" e senha "181094"
    Quando eu validar o login
    Então o login deve ser validado com sucesso e exibir uma mensagem de sucesso

  Cenário: Validar o login com credenciais incorretas
    Dado que tenho um usuário com login "usuario456" e senha "senha456"
    Quando eu validar o login
    Então o login não deve ser validado e exibir uma mensagem de falha


@usuario
Funcionalidade: Gravar Usuário
  Como um usuário
  Eu quero gravar um usuário no banco de dados
  Para garantir que o método salvarUsuarioDAO funcione corretamente

  Cenário: Gravar um novo usuário no sistema
    Dado que eu tenha um usuário com nome "Usuário Teste", login "usuario123" e senha "senha123"
    Quando eu gravar o usuário no banco de dados
    Então a operação de gravação deve ser bemsucedida