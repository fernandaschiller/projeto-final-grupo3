Feature: HG3R2 - Filtro por categorias
  Como usuário, mesmo que não esteja logado
  Quero realizar buscar produtos por categorias
  Para encontrar produtos da categoria que tenho interesse

  r1: Ao selecionar uma categoria, deve redirecionar (na mesma aba) para produtos da categoria selecionada
  r2: Deve ser possível ordenar resultados

  Scenario: Validar que resultado do filtro por categorias exibirá resultados conforme a categoria na mesma aba
    Given que usuario acessa pagina home
    When clicar em alguma categoria
    Then deve redirecionar para a pagina de produtos da categoria selecionada
    And deve redirecionar para o resultado na mesma aba

  Scenario: Validar funcao de ordenar resultados
    Given um usuario acessa a pagina de resultados por categoria
    When selecionar algum criterio de ordenacao
    Then deve ordenar resultados conforme criterio

  Scenario: Validar funcao de ordenar resultados por descontos
    Given um usuario acessa a pagina de resultados por categoria
    When selecionar criterio de ordenacao por descontos
    Then deve ordenar resultados conforme criterio desconto de forma decrescente

  Scenario: Validar funcao de ordenar resultados por menor preco
    Given um usuario acessa a pagina de resultados por categoria
    When selecionar criterio de ordenacao por menor preco
    Then deve ordenar resultados conforme preco de forma crescente

  Scenario: Validar funcao de ordenar resultados por maior preco
    Given um usuario acessa a pagina de resultados por categoria
    When selecionar criterio de ordenacao por maior preco
    Then deve ordenar resultados conforme preco de forma decrescente

  Scenario: Validar funcao de ordenar resultados por de A a Z
    Given um usuario acessa a pagina de resultados por categoria
    When selecionar criterio de ordenacao por A a Z
    Then deve ordenar resultados conforme ordem alfabetica crescente

  Scenario: Validar funcao de ordenar resultados por de Z a A
    Given um usuario acessa a pagina de resultados por categoria
    When selecionar criterio de ordenacao por Z a A
    Then deve ordenar resultados conforme ordem alfabetica decrescente


