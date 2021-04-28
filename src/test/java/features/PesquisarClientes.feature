@FullTesting
@PesquisarClientes

Feature: Pesquisar Clientes

  @PC_SmokeTesting
  Scenario: Pesquisar Clientes
    Given Eu tenha acesso ao endpoint /pessoas
    When Eu fizer uma pesquisa usando metodo GET informando DDD "11" e o numero "985388877"
    Then Eu devo ver que o corpo de resposta retornado esta dentro do especificado


  @PC_SmokeTesting
  Scenario: Pesquisar Clientes
    Given Eu tenha acesso ao endpoint /pessoas
    When Eu fizer uma pesquisa usando metodo GET informando DDD "11" e o numero "985388877"
    Then Eu devo verificar que o HTTP StatusCode retornado e 200

  @PC_NegativeTesting
  Scenario: Pesquisar Clientes
    Given Eu tenha acesso ao endpoint /pessoas
    When Eu fizer uma pesquisa usando metodo GET informando DDD "11" e o numero "789488877"
    Then Eu devo ver a mensagem de erro "Nao existe pessoa com o telefone (11)789488877"

  @PC_NegativeTesting
  Scenario: Pesquisar Clientes
    Given Eu tenha acesso ao endpoint /pessoas
    When Eu fizer uma pesquisa usando metodo GET informando DDD "99" e o numero "985388877"
    Then Eu devo ver a mensagem de erro "Nao existe pessoa com o telefone (99)985388877"

  @PC_NegativeTesting
  Scenario: Pesquisar Clientes
    Given Eu tenha acesso ao endpoint /pessoas
    When Eu fizer uma pesquisa usando metodo GET informando DDD "11" e o numero "Rommel Von"
    Then Eu devo verificar que o HTTP StatusCode retornado e 404

  @PC_NegativeTesting
  Scenario: Pesquisar Clientes
    Given Eu acesse um endpoint invalido como /cliente
    When Eu fizer uma pesquisa usando metodo GET informando DDD "11" e o numero "985388877"
    Then Eu devo verificar que o HTTP StatusCode retornado e 404
