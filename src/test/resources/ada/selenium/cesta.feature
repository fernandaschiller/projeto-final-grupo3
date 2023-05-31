@HG3R4
Feature:  Cesta de produtos
  Como usuário, mesmo que não esteja logado
  Quero poder adicionar e gerenciar produtos em uma cesta
  Para poder visualizar dados da minha possível compra

  Scenario: adicionar um produto na cesta
    Given fez a busca de um produto
    When ao comprar dois produtos
    Then ficar na mesma pagina


  Scenario: Ao clicar em "minha cesta" deve exibir informações dos produtos adicionados na cesta
    Given fez a busca de um produto
    When ao comprar dois produtos
    Then a cesta exibe informações


  Scenario: Deve ser possível excluir produtos da cesta
    Given fez a busca de um produto
    When ao comprar dois produtos
    Then é possível deletar um produto