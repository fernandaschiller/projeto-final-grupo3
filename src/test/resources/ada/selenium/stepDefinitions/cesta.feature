
@HG3R4
Feature:  Cesta de produtos
  HG3R4 - Cesta de produtos
  Como usu�rio, mesmo que n�o esteja logado
  Quero poder adicionar e gerenciar produtos em uma cesta
  Para poder visualizar dados da minha poss�vel compra


  Scenario: Ao clicar em comprar no card de um produto, o usu�rio n�o deve ser redirecionado
            para outra tela, apenas deve adicionar um produto na cesta
  Given fez a busca de um produto
  When ao comprar dois produtos
  Then ele se manter� na mesma p�gina


  Scenario: Ao clicar em "minha cesta" deve exibir informa��es dos produtos adicionados na cesta
  Given fez a busca de um produto
  When ao comprar dois produtos
  Then a cesta exibe informa��es


  Scenario: Deve ser poss�vel excluir produtos da cesta
  Given fez a busca de um produto
  When ao comprar dois produtos
  Then � poss�vel deletar um produto
