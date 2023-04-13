import java.util.*;

public class ExtratorIMDB implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json) {


        // Pegar só os dados que interresam (título, poster, Rating)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);


        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        for(Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }
        return conteudos;
    }

}
