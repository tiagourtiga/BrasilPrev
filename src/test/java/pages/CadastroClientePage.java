package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class CadastroClientePage {
    private static String path;
    private static Response response;


    private static final String validRequest = "{\n" +
            "    \"codigo\": 0,\n" +
            "    \"nome\": \"Rommel Von\",\n" +
            "    \"cpf\": \"12345678909\",\n" +
            "    \"enderecos\": [\n" +
            "        {\n" +
            "            \"logradouro\": \"Rua Alexandre Dumas\",\n" +
            "            \"numero\": 123,\n" +
            "            \"complemento\": \"Empresa\",\n" +
            "            \"bairro\": \"Chacara Santo Antonio\",\n" +
            "            \"cidade\": \"São Paulo\",\n" +
            "            \"estado\": \"SP\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"telefones\": [\n" +
            "        {\n" +
            "            \"ddd\": \"11\",\n" +
            "            \"numero\": \"985388877\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    protected static void getCodigoCliente() {
        String codigoCliente = response.jsonPath().get("codigo").toString();
        Assert.assertEquals("1", codigoCliente);
    }

    protected static void getNome() {
        String nome = response.jsonPath().get("nome");
        Assert.assertEquals("Rommel Von", nome);
    }

    protected static void getcpf() {
        String cpf = response.jsonPath().get("cpf");
        Assert.assertEquals("12345678909", cpf);
    }

    protected static void getCodigoEndereco() {
        String codigoEnderecos = response.jsonPath().get("enderecos[0].codigo").toString();
        Assert.assertEquals("1", codigoEnderecos);
    }

    protected static void getLogradouro() {
        String logradouro = response.jsonPath().get("enderecos[0].logradouro");
        Assert.assertEquals("Rua Alexandre Dumas", logradouro);

    }

    protected static void getNumeroEndereco() {
        String numeroEndereco = response.jsonPath().get("enderecos[0].numero").toString();
        Assert.assertEquals("123", numeroEndereco);
    }

    protected static void getComplemento() {
        String complemento = response.jsonPath().get("enderecos[0].complemento");
        Assert.assertEquals("Empresa", complemento);
    }

    protected static void getBairro() {
        String bairro = response.jsonPath().get("enderecos[0].bairro");
        Assert.assertEquals("Chacara Santo Antonio", bairro);
    }

    protected static void getCidade() {
        String cidade = response.jsonPath().get("enderecos[0].cidade");
        Assert.assertEquals("São Paulo", cidade);
    }

    protected static void getEstado() {
        String estado = response.jsonPath().get("enderecos[0].estado");
        Assert.assertEquals("SP", estado);
    }

    protected static void getCodigoTelefones() {
        String codigoTelefones = response.jsonPath().get("telefones[0].codigo").toString();
        Assert.assertEquals("1", codigoTelefones);
    }

    protected static void GetDdd() {
        String ddd = response.jsonPath().get("telefones[0].ddd");
        Assert.assertEquals("11", ddd);
    }

    protected static void getTelefone() {
        String telefone = response.jsonPath().get("telefones[0].numero");
        Assert.assertEquals("985388877", telefone);

    }


    protected static void getCadastroNovoClienteComTelefoneJaCadastrado() {
            String telefoneJaCadastradoRequest = "{\n" +
                    "    \"codigo\": 1,\n" +
                    "    \"nome\": \"Rommel Von\",\n" +
                    "    \"cpf\": \"32568524722\",\n" +
                    "    \"enderecos\": [\n" +
                    "        {\n" +
                    "            \"logradouro\": \"Rua Alexandre Dumas\",\n" +
                    "            \"numero\": 123,\n" +
                    "            \"complemento\": \"Empresa\",\n" +
                    "            \"bairro\": \"Chacara Santo Antonio\",\n" +
                    "            \"cidade\": \"São Paulo\",\n" +
                    "            \"estado\": \"SP\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"telefones\": [\n" +
                    "        {\n" +
                    "            \"ddd\": \"11\",\n" +
                    "            \"numero\": \"985388877\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
            response =
                    given()
                            .contentType(ContentType.JSON)
                            .body(telefoneJaCadastradoRequest)
                            .when()
                            .post(path)
                            .then()
                            .extract().response();
        }

    protected static void getCadastrarNovoClienteComCorpoDaRequestInvalido() {
        // Body em desacordo com especificação, sem o campo "cpf"
        String invalidRequest = "{\n" +
                "    \"codigo\": 1,\n" +
                "    \"nome\": \"Tiago Urtiga\",\n" +
                "    \"enderecos\": [\n" +
                "        {\n" +
                "            \"logradouro\": \"Comerciante Jose Miranda de Araujo\",\n" +
                "            \"numero\": 185,\n" +
                "            \"bairro\": \"Jardim Oceania\",\n" +
                "            \"cidade\": \"Joao  Pessoa\",\n" +
                "            \"estado\": \"PB\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"telefones\": [\n" +
                "        {\n" +
                "            \"ddd\": \"83\",\n" +
                "            \"numero\": \"999914829\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        response =
                given()
                        .contentType(ContentType.JSON)
                        .body(invalidRequest)
                        .when()
                        .post(path)
                        .then()
                        .extract().response();
    }

    protected static void getCadastrarNovoClienteComCorpoDaRequestEmBranco() {
        response =
                given()
                        .contentType(ContentType.JSON)
                        .body("")
                        .when()
                        .post(path)
                        .then()
                        .extract().response();
    }

    protected static void getCadastrarNovoClienteSemContentTypeNoHeader() {
        response =
                given()
                        .body(validRequest)
                        .when()
                        .post(path)
                        .then()
                        .extract().response();
    }

    protected static void getCadastrarNovoClienteComNomesDeCamposErradosNoCorpo() {
        //Body com nome dos campos diferentes do especificado
        String camposIncorretosRequest = "{\n" +
                "    \"codigos\": 1,\n" +
                "    \"nomes\": \"Rommel Von\",\n" +
                "    \"cpf\": \"95125875365\",\n" +
                "    \"enderecos\": [\n" +
                "        {\n" +
                "            \"logradouro\": \"Rua Alexandre Dumas\",\n" +
                "            \"numero\": 123,\n" +
                "            \"complemento\": \"Empresa\",\n" +
                "            \"bairro\": \"Chacara Santo Antonio\",\n" +
                "            \"cidade\": \"São Paulo\",\n" +
                "            \"estado\": \"SP\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"telefone\": [\n" +
                "        {\n" +
                "            \"ddd\": \"11\",\n" +
                "            \"numero\": \"955682436\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        response =
                given()
                        .contentType(ContentType.JSON)
                        .body(camposIncorretosRequest)
                        .when()
                        .post(path)
                        .then()
                        .extract().response();
    }

    protected static void CadastrarNovoClienteUtilizandoTipagemErradaNoCampoRequest() {
        //Utilizando tipagens diferentes do especificado em diversos campos do body
        String tipagemErradaDosCamposRequest = "{\n" +
                "    \"codigo\": \"1\",\n" +
                "    \"nome\": 99914829,\n" +
                "    \"cpf\": 09045411423,\n" +
                "    \"enderecos\": [\n" +
                "        {\n" +
                "            \"logradouro\": 9875642,\n" +
                "            \"numero\": \"123\",\n" +
                "            \"complemento\": 789456,\n" +
                "            \"bairro\": 321546,\n" +
                "            \"cidade\": 5465465,\n" +
                "            \"estado\": \"PB\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"telefones\": [\n" +
                "        {\n" +
                "            \"ddd\": 83,\n" +
                "            \"numero\": 999914829\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        response =
                given()
                        .contentType(ContentType.JSON)
                        .body(tipagemErradaDosCamposRequest)
                        .when()
                        .post(path)
                        .then()
                        .extract().response();
    }

    protected static void getCadastrarNovoCliente() {
        response =
                given()
                        .contentType(ContentType.JSON)
                        .body(validRequest)
                        .when()
                        .post(path)
                        .then()
                        .extract().response();
    }

}













