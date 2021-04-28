package steps;

import io.cucumber.java.en.When;
import pages.PesquisarClientePage;

public class PesquisarClientesSteps extends PesquisarClientePage{


    @When("Eu fizer uma pesquisa usando metodo GET informando DDD {string} e o numero {string}")
    public void pesquisarUsuarioPorDDDeNumero() {
        PesquisarClientePage.getPesquisarUsuarioporDDDeNumero("", "");
    }

}
