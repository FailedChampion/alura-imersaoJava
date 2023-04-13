import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {

    public String buscaDados(String url) throws SiteInvalidoException {
        try {
            URI address =  URI.create(url);
            var client = HttpClient.newHttpClient();
            var rq = HttpRequest.newBuilder(address).GET().build();
            HttpResponse<String> res = client.send(rq, HttpResponse.BodyHandlers.ofString());
            return res.body();
        } catch(IOException | InterruptedException | IllegalArgumentException ex) {
            throw new SiteInvalidoException("Link inválido ou não retorna nada.");
        }



    }
}
