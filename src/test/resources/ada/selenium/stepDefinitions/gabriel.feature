Feature: Teste com as features dos outros integrantes

  HG3R1 - Busca de produtos
    Como usu�rio, mesmo que n�o esteja logado,
    Quero realizar busca por produtos
    Para encontrar o produto que tenho interesse

  r1: Ao clicar no item de busca e n�o digitar um texto,
      deve exibir uma sugest�o dos termos mais buscados
  r2: Ao efetuar busca de produto, deve redirecionar para uma tela
      de resultados da busca realizada (na mesma guia)
  r3: Na tela do resultado da busca deve informar a quantidade de produtos retornados
      e deve ser poss�vel realizar filtros dos produtos


  @HG3R1
 Scenario: r2
    Given que o usuario acesse a pagina
    When ao efetuar busca de produto
    Then levar a tela de resultados
