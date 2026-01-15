
Feature: Login no sistema

  @loginInvalido @login
  Scenario: Login com credenciais inválidas
    Given que o usuário está na página de login
    When o usuário insere o email "veronicasp54@gmail.com"
    When o usuário insere a senha invalida "testes12"
    Then o sistema deve exibir a mensagem de erro "Invalid login credentials"
