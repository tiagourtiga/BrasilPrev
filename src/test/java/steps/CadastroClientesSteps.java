package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.CadastroClientePage;



public class CadastroClientesSteps extends CadastroClientePage {

    @When("Eu adicionar um cliente usando metodo POST")
    public void cadastrarNovoCliente() {
        CadastroClientePage.getCadastrarNovoCliente();

    }

    @And("Eu devo ver que o corpo de resposta retornado esta dentro do especificado")
    public void validarCadastroDeNovoCliente() {
        CadastroClientePage.getCodigoCliente();
        CadastroClientePage.getNome();
        CadastroClientePage.getcpf();
        CadastroClientePage.getCodigoEndereco();
        CadastroClientePage.getLogradouro();
        CadastroClientePage.getNumeroEndereco();
        CadastroClientePage.getComplemento();
        CadastroClientePage.getBairro();
        CadastroClientePage.getCidade();
        CadastroClientePage.getEstado();
        CadastroClientePage.getCodigoTelefones();
        CadastroClientePage.GetDdd();
        CadastroClientePage.getTelefone();

    }


    @When("Eu adicionar um cliente usando metodo POST com CPF nunca cadastrado porem com telefone ja cadastrado")
    public void cadastrarNovoClienteComTelefoneJaCadastrado() {
        CadastroClientePage.getCadastroNovoClienteComTelefoneJaCadastrado();
    }

    @When("Eu adicionar um cliente usando metodo POST porem com corpo da request invalido")
    public void cadastrarNovoClienteComCorpoDaRequestInvalido() {
        CadastroClientePage.getCadastrarNovoClienteComCorpoDaRequestInvalido();
        }


    @When("Eu adicionar um cliente usando metodo POST porem com corpo da request em branco")
    public void cadastrarNovoClienteComCorpoDaRequestEmBranco() {
        CadastroClientePage.getCadastrarNovoClienteComCorpoDaRequestEmBranco();
    }

    @When("Eu adicionar um cliente usando metodo POST porem sem content-type no header")
    public void cadastrarNovoClienteSemContentTypeNoHeader() {
        CadastroClientePage.getCadastrarNovoClienteSemContentTypeNoHeader();
    }

    @When("Eu adicionar um cliente usando metodo POST porem com nomes de campos errados no corpo")
    public void cadastrarNovoClienteComNomesDeCamposErradosNoCorpo() {
        CadastroClientePage.getCadastrarNovoClienteComNomesDeCamposErradosNoCorpo();

    }

    @When("Eu adicionar um cliente usando metodo POST porem com tipagem errada dos campos no corpo do request")
    public void cadastrarNovoClienteUtilizandoTipagemErradaNoCampoDoRequest() {
        CadastroClientePage.CadastrarNovoClienteUtilizandoTipagemErradaNoCampoRequest();
    }
}
