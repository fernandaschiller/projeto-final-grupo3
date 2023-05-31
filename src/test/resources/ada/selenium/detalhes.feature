
@HG3R3
Feature: HG3R3 - Detalhes de um produto
HG3R3 - Detalhes de um produto
Como usuário, mesmo que não esteja logado
Quero ver detalhes de um produto para ver mais informações do produto.
r1: Deve exibir imagem, dados de pagamento, descrição do produto e outras informações
r2: Deve exibir no final da pagina sugestões de produtos similares


  @Smoke
  Scenario: Validar se a imagem do produto está sendo exibida corretamente
    Given Que estou na página de um produto escolhido
    Then a imagem do produto deve ser mostrada

#  @Smoke
#  Scenario: Validar se os produtos relacionados estão sendo exibidos corretamente
#    Given Que estou na página de um produto escolhido
#    When Estiver no fim da página
#    Then devem ser apresentados produtos relacionados

  @Regression
  Scenario: Validar se a descrição do produto está sendo exibida corretamente
    Given Que estou na página de um produto escolhido
    Then deve ser apresentada uma descrição sobre o produto

  @Regression
  Scenario: Validar se as especificações do produto estão sendo exibidas corretamente
    Given Que estou na página de um produto escolhido
    Then devem ser apresentadas as especificações do produto

#  @Regression
#  Scenario: Validar se o cep digitado está sendo exibido corretamente
#    Given Que estou na página de um produto escolhido
#    When preencho as informações de um cep
#    Then deve retornar o cep correto da região



