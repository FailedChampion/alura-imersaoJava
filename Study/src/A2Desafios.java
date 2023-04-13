import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class A2Desafios {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexão HTTP e buscar os top 250 filmes



        String link = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI address =  URI.create(link);
        var client = HttpClient.newHttpClient();
        var rq = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> res = client.send(rq, HttpResponse.BodyHandlers.ofString());
        String body = res.body();



        // Pegar só os dados que interresam (título, poster, Rating)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);


        // exibir e manipular os dados
        var geradora = new A2();
        for (Map<String, String> filme : listaDeFilmes)  {
            String nota =  filme.get("imDbRating");
            String titulo = filme.get("title");
            float castaNota = Float.parseFloat(nota);
            if(titulo.contains(":")) {
                String novoTitulo = titulo.replace(":", "");
                String nomeArquivo = novoTitulo + ".png";
                InputStream is = new URI(filme.get("image")).toURL().openStream();
                if(castaNota >= 7) {
                    geradora.cria(is, nomeArquivo, "MUITO BOM!");
                } else if (castaNota < 7 ) {
                    geradora.cria(is, nomeArquivo, "MAIS OU MENOS!");
                }
            } else {
                String nomeArquivo = titulo + ".png";
                InputStream is = new URI(filme.get("image")).toURL().openStream();
                if(castaNota >= 7) {
                    geradora.cria(is, nomeArquivo, "MUITO BOM!");
                } else if (castaNota < 7 ) {
                    geradora.cria(is, nomeArquivo, "MAIS OU MENOS!");
                }
            }



            System.out.println(filme.get("title"));
            //System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
    }
}
