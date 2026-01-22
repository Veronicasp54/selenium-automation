Feature: Login

  @loginValido @login
  Scenario: Login com credenciais válidas
    Given usuário está na página de login
    When o usuário insere o email "usuario_invalido.email"
    And o usuário insere a senha "usuario_invalido.senha"
    And o usuário clica no botão Sign In
    Then o sistema apresenta a página "account.endpoint" com mensagem "Account Details and Order History"

