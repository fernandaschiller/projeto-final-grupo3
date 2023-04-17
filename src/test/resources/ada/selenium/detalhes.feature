Feature: HG3R3 - Detalhes de um produto

#  HG3R3 - Detalhes de um produto
#  Como usuário, mesmo que não esteja logado Quero ver detalhes de um produto
#  Para para ver mais informações do produto.
#
#  r1: Deve exibir imagem, dados de pagamento, descrição do produto e outras informações
#  r2: Deve exibir no final da pagina sugestões de produtos similares

  Scenario: Validar mudança para apágina do produto
    Given Que estou na página inicial da livraria Saraiva
    When Quando, eu clico em um produto
    Then devo ser redirecionado para a página específica do produto

  Scenario: Validar se a imagem do produto está sendo exibida corretamente
    Given Que estou na página inicial da livraria Saraiva
    When Quando, eu clico em um produto e sou direcionado a sua página epecífica
    Then deve aparecer a imagem do produto

  Scenario: Validar se se os dados do pagamento do produto estão sendo exibidos corretamente
    Given Que estou na página inicial da livraria Saraiva
    When Quando, eu clico em um produto e sou direcionado a sua página epecífica
    Then deve aparecer os dados do pagamento do produto

  Scenario: Validar se o cep digitado está sendo exibido corretamente
    Given an example scenario
    When all step definitions are implemented
    Then the scenario passes

  Scenario: Validar se a descrição do produto está sendo exibida corretamente
    Given an example scenario
    When all step definitions are implemented
    Then the scenario passes

  Scenario: Validar se as especificações do produto estão sendo exibidas corretamente
    Given an example scenario
    When all step definitions are implemented
    Then the scenario passes

  Scenario: Validar se os produtos relacionaods estão sendo exibidos corretamente
    Given an example scenario
    When all step definitions are implemented
    Then the scenario passes


