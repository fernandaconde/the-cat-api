import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest extends MassaDeDados {

    @BeforeClass
    public static void urlbase() {
        baseURI = "https://api.thecatapi.com/v1";
    }

    @Test
    public void cadastro() {
        Response response =
                given()
                        .contentType("application/json")
                        .body(bodyCadastro).
                when()
                        .post(urlCadastro);

        validacaoSucesso(response);
    }

    @Test
    public void votacao() {
        Response response =
                given()
                        .contentType("application/json")
                        .header("x-api-key", apiKey)
                        .body(bodyVotacao).
                when()
                        .post(urlVotacao);

        validacaoSucesso(response);

        vote_id = response.jsonPath().getString("id");
        System.out.println("Id: " + vote_id);
    }

    @Test
    public void deletaVotacao() {
        votacao();
        deletaVoto();
    }

    private void deletaVoto() {
        Response response =
                given()
                        .contentType("application/json")
                        .header("x-api-key", apiKey)
                        .pathParam("vote_id", vote_id).
                when()
                        .delete(urlDeletaVotacao);

        validacaoSucesso(response);
    }

    @Test
    public void favoritaDesfavorita() {
        favorita();
        desfavorita();
    }

    private void favorita() {
        Response response =
                given()
                        .contentType("application/json")
                        .header("x-api-key", apiKey)
                        .body(bodyFavorita).
                when()
                        .post(urlFavorita);

        validacaoSucesso(response);

        favourite_id = response.jsonPath().getString("id");
        System.out.println("Id: " + favourite_id);
    }

    private void desfavorita() {
        Response response =
                given()
                        .contentType("application/json")
                        .header("x-api-key", apiKey)
                        .pathParam("favourite_id", favourite_id).
                when()
                        .delete(urlDesfavorita);

        validacaoSucesso(response);
    }

    public void validacaoSucesso(Response response) {
        response.then()
                .body("message", containsString("SUCCESS"))
                .statusCode(200);

        System.out.println("Retorno da API: " + response.body().asString());
        System.out.println("---------------------------------------------");
    }

}
