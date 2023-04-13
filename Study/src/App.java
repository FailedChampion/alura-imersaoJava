import java.io.InputStream;
import java.net.URI;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // Fazer uma conexão HTTP e buscar os top 250 filmes
        ExtratorDeConteudo nasa = new ExtratorNASA();
        ExtratorDeConteudo imdb = new ExtratorIMDB();
        var geradora = new A2();


        // exibir e manipular os dados
        List<Conteudo> conteudos = nasa.extraiConteudos(Links.NASA.linkNASA());

        for (int i = 0; i < 4; i++) {
            Conteudo conteudo = conteudos.get(i);
            String nomeArquivo = conteudo.titulo() + ".png";
            String titulo = conteudo.titulo();
            InputStream is = new URI(conteudo.urlImagem()).toURL().openStream();


            if (nomeArquivo.contains(":")) {
                String novoTitulo = nomeArquivo.replace(":", "");
                String nomeArquivo1 = novoTitulo + ".png";
                geradora.cria(is, nomeArquivo1, "POGGERS!");
                System.out.println(titulo);
            } else {
                geradora.cria(is, nomeArquivo, "POGGERS!");
                System.out.println(titulo);
            }
            System.out.println();
        }
    }
}

