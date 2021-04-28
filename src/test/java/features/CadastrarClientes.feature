@FullTesting
@CadastrarClientes

Feature: Cadastrar Novos Clientes

  @CC_SmokeTesting
  Scenario: Cadastrar um novo cliente
    Given Eu tenha acesso ao endpoint /pessoas
    When Eu adicionar um cliente usando metodo POST
    And Eu devo verificar que o HTTP StatusCode retornado e 201
    Then Eu devo ver que o corpo de resposta retornado esta dentro do especificado

  @CC_NegativeTesting
  Scenario: Cadastrar um novo cliente
    Given Eu tenha acesso ao endpoint /pessoas
    When Eu adicionar um cliente usando metodo POST
    And Eu devo verificar que o HTTP StatusCode retornado e 400
    Then Eu devo ver a mensagem de erro "Já existe pessoa cadastrada com o CPF 12345678909"

  @CC_NegativeTesting
  Scenario: Cadastrar um novo cliente
    Given Eu tenha acesso ao endpoint /pessoas
    When Eu adicionar um cliente usando metodo POST com CPF nunca cadastrado porem com telefone ja cadastrado
    And Eu devo verificar que o HTTP StatusCode retornado e 400
    Then Eu devo ver a mensagem de erro "Já existe pessoa cadastrada com o Telefone (11)985388877"

  @CC_NegativeTesting
  Scenario: Cadastrar um novo cliente
    Given Eu tenha acesso ao endpoint /pessoas
    When Eu adicionar um cliente usando metodo POST porem sem content-type no header
    Then Eu devo verificar que o HTTP StatusCode retornado e 415

  @CC_NegativeTesting
  Scenario: Cadastrar um novo cliente
    Given Eu tenha acesso ao endpoint /pessoas
    When Eu adicionar um cliente usando metodo POST porem com corpo da request em branco
    Then Eu devo verificar que o HTTP StatusCode retornado e 400

  @CC_NegativeTesting
  Scenario: Cadastrar um novo cliente
    Given Eu tenha acesso ao endpoint /pessoas
    When Eu adicionar um cliente usando metodo POST porem com corpo da request invalido
    And Eu devo verificar que o HTTP StatusCode retornado e 400
    Then Eu devo ver a mensagem de erro "O corpo da Request esta fora do padrao"

  @CC_NegativeTesting
  Scenario: Cadastrar um novo cliente
    Given Eu tenha acesso ao endpoint /pessoas
    When Eu adicionar um cliente usando metodo POST porem com nomes de campos errados no corpo
    And Eu devo verificar que o HTTP StatusCode retornado e 400
    Then Eu devo ver a mensagem de erro "O corpo da Request esta fora do padrao"

  @CC_NegativeTesting
  Scenario: Cadastrar um novo cliente
    Given Eu acesse um endpoint invalido como /pessoa
     When Eu adicionar um cliente usando metodo POST
    Then Eu devo verificar que o HTTP StatusCode retornado e 404

  @CC_NegativeTesting
  Scenario: Cadastrar um novo cliente
    Given Eu tenha acesso ao endpoint /pessoas
    When Eu adicionar um cliente usando metodo POST porem com tipagem errada dos campos no corpo do request
    And Eu devo verificar que o HTTP StatusCode retornado e 400
    Then Eu devo ver a mensagem de erro "O corpo da Request esta fora do padrao"


