Feature: Catalogo

  @acessarCatalogo
  Scenario: Acessar o Catalog no menu lateral
    Given o usuário está autenticado na página inicial
    When o usuário clica no menu lateral "Catalog"
    Then o sistema deve direcionar para a página "https://sauce-demo.myshopify.com/collections/all"
    And a página deve exibir o título "Products"
    And deve existir pelo menos 1 produto listado no catálogo