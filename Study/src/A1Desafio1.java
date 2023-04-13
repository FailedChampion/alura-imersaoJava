import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class A1Desafio1 {

    public static String link;

        public static void main(String[] args) throws Exception {
            // Fazer uma conexão HTTP e buscar os top 250 filmes
            // Pegar só os dados que interresam (título, poster, Rating)
            // & exibir e manipular os dados
            filmesPopulares();

        }

    public static String retornarBody() throws Exception {
        URI address =  URI.create(link);
        var client = HttpClient.newHttpClient();
        var rq = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> res = client.send(rq, HttpResponse.BodyHandlers.ofString());

        return res.body();
    }

    public static void filmesPopulares() throws Exception {
        A1Desafio1.link = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";

        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(retornarBody());
        System.out.println("Filmes Populares:");


        for(Map<String, String> filme : listaDeFilmes) {

            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
    }

    public static void melhoresFilmes() throws Exception {
        A1Desafio1.link = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(retornarBody());
        System.out.println("Melhores Filmes:");


        for(Map<String, String> filme : listaDeFilmes) {

            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
    }

    public static void seriesPopulares() throws Exception {
        A1Desafio1.link = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(retornarBody());
        System.out.println("Séries Populares:");

        for(Map<String, String> filme : listaDeFilmes) {

            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
    }

    public static void melhoresSeries() throws Exception {
        A1Desafio1.link = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(retornarBody());
        System.out.println("Melhores Séries:");

        for(Map<String, String> filme : listaDeFilmes) {

            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
    }


}