Feature: Catalogo

@acessarCatalogo
Scenario: Acessar o Catalog no menu lateral
Given o usuário está autenticado na página inicial
When o usuário clica no menu lateral "Catalog"
Then o sistema deve direcionar para a página "https://sauce-demo.myshopify.com/collections/all"