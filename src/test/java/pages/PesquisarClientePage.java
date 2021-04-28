package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.when;

public class PesquisarClientePage {
    public static String path;
    public static Response response;

    public static void getPesquisarUsuarioporDDDeNumero(String DDD, String numero) {
        response =
                when()
                        .get(path + "/" + DDD + "/" + numero)
                        .then()
                        .contentType(ContentType.JSON)
                        .extract().response();
    }
}
