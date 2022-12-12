import resources.ImdbApi;

import javax.swing.text.html.parser.Parser;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class app {
    static public void main(String[] args) throws Exception {
        //conexão HTTP na API e buscando os 250 melhores filmes
        ImdbApi endpoint =  new ImdbApi();
        String url = endpoint.getTop250Movies();
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        for (Map<String, String> filme : listaDeFilmes) {
            String rating = filme.get("imDbRating");
            int arrounded;
            try {
                arrounded = Integer.parseInt(rating.substring(0,1));
            }
            catch (NumberFormatException e) {
                arrounded = 0;
            }
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(arrounded);
            for (int i = 0; i < arrounded; i++) {
                System.out.print("\u001b[33m \u001b[40m ☆ \u001b[m");
            }
                System.out.println("");
        }
        System.out.println(listaDeFilmes.size());
//        for (Map<String, String> filme : listaDeFilmes) {
//            System.out.println(filme.get("title"));
//            System.out.println(filme.get("image"));
//            System.out.println(filme.get("imDbRating"));
//            System.out.println("\u001b[33m \u001b[40m ☆ \u001b[m");
//            System.out.println();
//        }
//
//        System.out.println(listaDeFilmes.size());
//        System.out.println(listaDeFilmes.get(0));

    }
}
