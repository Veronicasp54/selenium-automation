
Feature: Carrinho
@adicionarProdutoCarrinho
Scenario: Selecionar um produto no catálogo e adicionar ao carrinho
    Given o usuário selecionou Catalogo no menu lateral
    When o usuário seleciona um produto no Catologo
    And o usuário clica no botão Add to Cart
    Then o produto deve ser adicionado ao carrinho

