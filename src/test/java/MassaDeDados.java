public class MassaDeDados {

    String vote_id;
    String favourite_id;

    String apiKey = "b80c2e87-ea28-4529-9745-7a0de82685f6";

    String urlCadastro = "/user/passwordlesssignup";
    String bodyCadastro = "{\"email\": \"fernog36@gmail.com\",\"appDescription\": \"estudos teste de api\"}";

    String urlVotacao = "/votes/";
    String bodyVotacao = "{\"image_id\":\"cj4\",\"value\":true,\"sub_id\":\"demo-a372f6\"}";

    String urlDeletaVotacao = "/votes/{vote_id}";

    String urlFavorita = "/favourites";
    String bodyFavorita = "{\"image_id\": \"9ccXTANkb\",\"sub_id\": \"your-user-1234\"}";

    String urlDesfavorita = "/favourites/{favourite_id}";
}
