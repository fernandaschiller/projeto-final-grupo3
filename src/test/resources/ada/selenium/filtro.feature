@HG3R2
Feature: HG3R2 - Filtro por categorias
  Como usuário, mesmo que não esteja logado
  Quero realizar buscar produtos por categorias
  Para encontrar produtos da categoria que tenho interesse

  r1: Ao selecionar uma categoria, deve redirecionar (na mesma aba) para produtos da categoria selecionada
  r2: Deve ser possível ordenar resultados


  @Regression
  @Smoke
  @Categorias
  Scenario: Validar que opcoes de categorias sao exibidas ao passar o mouse no menu categorias
    Given que o usuario acesse a pagina home 'https://www.saraiva.com.br/'
    When passar o mouse na opcao Categorias
    Then deve exibir menu de categorias

  @Regression
  @Smoke
  @Categorias
  Scenario: Validar que resultado do filtro por categorias exibirá resultados na mesma aba
    Given que o usuario acesse a pagina home 'https://www.saraiva.com.br/'
    When clicar na categoria em alguma categoria
    Then deve redirecionar para o resultado na mesma aba

  @Regression
  @Smoke
  @Categorias
  Scenario: Validar que resultado do filtro por categorias exibirá resultados conforme categoria selecionada
    Given que o usuario acesse a pagina home 'https://www.saraiva.com.br/'
    When clicar na categoria Livros
    Then deve redirecionar para a pagina de produtos da categoria 'Livros'

  @Regression
  @Categorias
  Scenario: Validar que resultado do filtro por categorias exibirá resultados corretos se clicar em Livros
    Given que o usuario acesse a pagina home 'https://www.saraiva.com.br/'
    When clicar na categoria Livros
    Then deve redirecionar para a pagina de produtos da categoria 'Livros'

  @Regression
  @Categorias
  Scenario: Validar que resultado do filtro por categorias exibirá resultados corretos se clicar em Papelaria
    Given que o usuario acesse a pagina home 'https://www.saraiva.com.br/'
    When clicar na categoria Papelaria
    Then deve redirecionar para a pagina de produtos da categoria 'Papelaria'

  @Regression
  @Categorias
  Scenario: Validar que resultado do filtro por categorias exibirá resultados corretos se clicar em Presentes
    Given que o usuario acesse a pagina home 'https://www.saraiva.com.br/'
    When clicar na categoria Presentes
    Then deve redirecionar para a pagina de produtos da categoria 'Presentes'

  @Regression
  @Categorias
  Scenario: Validar que resultado do filtro por categorias exibirá resultados corretos se clicar em Brinquedos
    Given que o usuario acesse a pagina home 'https://www.saraiva.com.br/'
    When clicar na categoria Brinquedos
    Then deve redirecionar para a pagina de produtos da categoria 'Brinquedos'

  @Regression
  @Categorias
  Scenario: Validar que resultado do filtro por categorias exibirá resultados corretos se clicar em Bebe
    Given que o usuario acesse a pagina home 'https://www.saraiva.com.br/'
    When clicar na categoria Bebê
    Then deve redirecionar para a pagina de produtos da categoria 'Bebê'

  @Smoke
  @Regression
  @Subcategorias
  Scenario: Validar que resultado do filtro por subcategorias exibirá resultados conforme subcategoria selecionada
    Given que o usuario acesse a pagina home 'https://www.saraiva.com.br/'
    When passar o mouse sobre a categoria Livros
    Then deve exibir a subcategoria de 'Livros'

  @Regression
  @Subcategorias
  Scenario: Validar que resultado do filtro por subcategorias exibirá resultados conforme subcategoria de Livros
    Given que o usuario acesse a pagina home 'https://www.saraiva.com.br/'
    When passar o mouse sobre a categoria Livros
    Then deve exibir a subcategoria de 'Livros'

  @Regression
  @Subcategorias
  Scenario: Validar que resultado do filtro por subcategorias exibirá resultados conforme subcategoria de Papelaria
    Given que o usuario acesse a pagina home 'https://www.saraiva.com.br/'
    When passar o mouse sobre a categoria Papelaria
    Then deve exibir a subcategoria de 'Papelaria'

  @Regression
  @Subcategorias
  Scenario: Validar que resultado do filtro por subcategorias exibirá resultados conforme subcategoria de Presentes
    Given que o usuario acesse a pagina home 'https://www.saraiva.com.br/'
    When passar o mouse sobre a categoria Presentes
    Then deve exibir a subcategoria de 'Presentes'

  @Regression
  @Subcategorias
  Scenario: Validar que resultado do filtro por subcategorias exibirá resultados conforme subcategoria de Brinquedos
    Given que o usuario acesse a pagina home 'https://www.saraiva.com.br/'
    When passar o mouse sobre a categoria Brinquedos
    Then deve exibir a subcategoria de 'Brinquedos'

  @Regression
  @Subcategorias
  Scenario: Validar que resultado do filtro por subcategorias exibirá resultados conforme subcategoria de Bebe
    Given que o usuario acesse a pagina home 'https://www.saraiva.com.br/'
    When passar o mouse sobre a categoria Bebe
    Then deve exibir a subcategoria de 'Beb%C3%AA'

  @Smoke
  @Regression
  @Ordenar
  Scenario: Validar que funcao de ordenar resultados é exibida ao clicar em ordenar
    Given um usuario acessa a pagina de resultados por categoria 'https://www.saraiva.com.br/livros'
    When clicar em ordenar
    Then deve exibir as opcoes de ordenar resultados

  @Regression
  @Ordenar
  Scenario: Validar funcao de ordenar resultados
    Given um usuario acessa a pagina de resultados por categoria 'https://www.saraiva.com.br/livros'
    When selecionar algum criterio de ordenacao
    Then deve ordenar resultados conforme criterio

  @Regression
  @Ordenar
  @CriteriosOrdenacao
  Scenario: Validar funcao de ordenar resultados por descontos
    Given um usuario acessa a pagina de resultados por categoria 'https://www.saraiva.com.br/livros'
    When selecionar criterio de ordenacao por descontos
    Then deve ordenar resultados conforme criterio desconto de forma decrescente

  @Regression
  @Ordenar
  @CriteriosOrdenacao
  Scenario: Validar funcao de ordenar resultados por menor preco
    Given um usuario acessa a pagina de resultados por categoria 'https://www.saraiva.com.br/livros'
    When selecionar criterio de ordenacao por menor preco
    Then deve ordenar resultados conforme preco de forma crescente

  @Regression
  @Ordenar
  @CriteriosOrdenacao
  Scenario: Validar funcao de ordenar resultados por maior preco
    Given um usuario acessa a pagina de resultados por categoria 'https://www.saraiva.com.br/livros'
    When selecionar criterio de ordenacao por maior preco
    Then deve ordenar resultados conforme preco de forma decrescente

  @Regression
  @Ordenar
  @CriteriosOrdenacao
  Scenario: Validar funcao de ordenar resultados por de A a Z
    Given um usuario acessa a pagina de resultados por categoria 'https://www.saraiva.com.br/livros'
    When selecionar criterio de ordenacao por A a Z
    Then deve ordenar resultados conforme ordem alfabetica crescente

  @Regression
  @Ordenar
  @CriteriosOrdenacao
  Scenario: Validar funcao de ordenar resultados por de Z a A
    Given um usuario acessa a pagina de resultados por categoria 'https://www.saraiva.com.br/livros'
    When selecionar criterio de ordenacao por Z a A
    Then deve ordenar resultados conforme ordem alfabetica decrescente

