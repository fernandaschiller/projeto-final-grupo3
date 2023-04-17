Feature: An example

  HG3R1 - Busca de produtos
    Como usuário, mesmo que não esteja logado,
    Quero realizar busca por produtos
    Para encontrar o produto que tenho interesse

  r1: Ao clicar no item de busca e não digitar um texto, deve exibir uma sugestão dos termos mais buscados
  r2: Ao efetuar busca de produto, deve redirecionar para uma tela de resultados da busca realizada (na mesma guia)
  r3: Na tela do resultado da busca deve informar a quantidade de produtos retornados e deve ser possível realizar filtros dos produ

  HG3R2 - Filtro por categorias
    Como usuário, mesmo que não esteja logado
    Quero realizar buscar produtos por categorias
    Para encontrar produtos da categoria que tenho interesse

  r1: Ao selecionar uma categoria, deve redirecionar (na mesma aba) para produtos da categoria selecionada
  r2: Deve ser possível ordenar resultados

  HG3R3 - Detalhes de um produto
    Como usuário, mesmo que não esteja logado
    Quero ver detalhes de um produto
    Para para ver mais informações do produto

  r1: Deve exibir imagem, dados de pagamento, descrição do produto e outras informações
  r2: Deve exibir no final da pagina sugestões de produtos similares

  Scenario: The example
    Given an example scenario
    When all step definitions are implemented
    Then the scenario passes
