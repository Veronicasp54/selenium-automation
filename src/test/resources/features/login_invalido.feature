
Feature: Login no sistema

  @loginInvalido @login
  Scenario: Login com credenciais inválidas
    Given que o usuário está na página de login
    When o usuário insere o email "usuario_invalido.email"
    And o usuário insere a senha "usuario_invalido.senha"
    Then o sistema deve exibir a mensagem de erro "Invalid login credentials"
