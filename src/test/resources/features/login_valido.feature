Feature: Login

  @loginValido
  Scenario: Login com credenciais válidas
    Given usuário está na página de login
    When o usuário insere email "veronicasp54@gmail.com"
    And o usuário insere senha "testes123"
    And o usuário clica no botão Sign In
    Then o sistema apresenta a página "https://sauce-demo.myshopify.com/account"
