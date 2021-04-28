package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;



public class ComunSteps {
    public String path;
    public Response response;

    @Given("Eu tenha acesso ao endpoint {word}")
    public void setUp(String endpoint) {
        RestAssured.baseURI = "http://localhost:8080";
        path = endpoint;
    }

    @Given("Eu acesse um endpoint invalido como {word}")
    public void setUpPathIncorreto(String endpoint) {
        RestAssured.baseURI = "http://localhost:8080";
        path = endpoint;
    }

    @And("Eu devo verificar que o HTTP StatusCode retornado e {int}")
    public void validarStatusCode(int codigo) {
        Assert.assertEquals(codigo, response.getStatusCode());
    }

    @And("Eu devo ver a mensagem de erro {string}")
    public void validarMensagemDeErro(String mensagem) {
        String mensagemDeErro = response.jsonPath().get("erro");

        Assert.assertEquals(mensagem, mensagemDeErro);
    }

}
