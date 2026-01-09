Feature: Produto

  @removerProdutoCarrinho
  Scenario: Remover produto do carrinho
    Given adicionou produto no carrinho
    And o usuário selecionou a opção My Cart
    When o usuário clica no link de remover ao lado do produto
    Then o sistema apresentará a mensagem de que o carrinho está vazio "Your cart is empty."
