@busca_produtos
Feature: Busca de produtos

  Como usuário, mesmo que não esteja logado,
  Quero realizar busca por produtos
  Para encontrar o produto que tenho interesse

  r1: Ao clicar no item de busca e não digitar um texto, deve exibir uma sugestão dos termos mais buscados
  r2: Ao efetuar busca de produto, deve redirecionar para uma tela de resultados da busca realizada (na mesma guia)
  r3: Na tela do resultado da busca deve informar a quantidade de produtos retornados e deve ser possível realizar filtros dos produtos

  Scenario: Validar presença da caixa de pesquisa
    Given que o usuário acesse a página home 'https://www.saraiva.com.br/'
    Then deve exibir caixa de pesquisa

  Scenario: Validar sugestão dos termos mais buscados no item de busca da página
    Given que o usuário acesse a página home 'https://www.saraiva.com.br/'
    When usuário clicar na caixa de pesquisa
    Then deve exibir sugestão dos termos mais buscados

  Scenario: Validar busca de produto
    Given que o usuário acesse a página home 'https://www.saraiva.com.br/'
    When usuário clicar na caixa de pesquisa
    And usuário digitar 'Harry Potter' na caixa de pesquisa
    Then deve exibir uma tela com os resultados relevantes da busca realizada na mesma guia

  Scenario: Validar seleção de um produto que aparece nos termos mais buscados
    Given que o usuário acesse a página home 'https://www.saraiva.com.br/'
    When usuário clicar na caixa de pesquisa
    Then deve exibir sugestão dos termos mais buscados
    And deve ser possível clicar em um item sugerido nos termos mais buscados
    And deve exibir uma tela com os resultados relevantes da busca realizada na mesma guia

  Scenario: Validar quantidade de produtos retornados e possibilidade de aplicar filtros
    Given que o usuário acesse a página home 'https://www.saraiva.com.br/'
    When usuário clicar na caixa de pesquisa
    And usuário digitar 'Harry Potter' na caixa de pesquisa
    Then deve exibir uma tela com os resultados relevantes da busca realizada na mesma guia
    And deve ser possível verificar a quantidade de produtos retornados, no canto superior direito da tela
    And a opção de filtro deve estar disponível

  Scenario: Validar busca de produto não encontrado
    Given que o usuário acesse a página home 'https://www.saraiva.com.br/'
    When usuário clicar na caixa de pesquisa
    And usuário digitar 'xxxx1234' na caixa de pesquisa
    Then deve exibir uma mensagem de erro informando que nenhum resultado foi encontrado

  Scenario: Validar busca sem sugestão
    Given que o usuário acesse a página home 'https://www.saraiva.com.br/'
    When usuário clicar na caixa de pesquisa
    And usuário digitar 'xxxx1234' na caixa de pesquisa mas não apertar enter
    Then deve aparecer a mensagem 'SEM SUGESTÕES'