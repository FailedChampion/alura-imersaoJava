import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class A1Desafio3 {

    public static String link;



    public static void main(String[] args) throws Exception {
        filmesPopulares();
        melhoresFilmes();
        seriesPopulares();
        melhoresSeries();




    }

    public static String retornarBody() throws Exception {
        URI address =  URI.create(link);
        var client = HttpClient.newHttpClient();
        var rq = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> res = client.send(rq, HttpResponse.BodyHandlers.ofString());

        return res.body();
    }

    public static void filmesPopulares() throws Exception {
        try(InputStream input = new FileInputStream("link.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            A1Desafio3.link = prop.getProperty("link.filmesPopulares");
        }
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(retornarBody());
        System.out.println(decor("bold") + "Filmes Populares:" + decor("reset"));

        for(Map<String, String> filme : listaDeFilmes) {

            System.out.println(decor("vermelho") + decor("italic") + filme.get("title") + decor("reset"));
            System.out.print(decor("reset"));
            System.out.println(decor("verde") +  filme.get("image") + decor("reset"));
            String nota = filme.get("imDbRating");
            StringBuilder st = new StringBuilder();
            int i = 0;
            float casta =  Float.parseFloat(nota); // 9.2
            int castaDnv = (int) casta;

            while (true) {
                st.append(decor("estrela"));
                i++;
                if (i == castaDnv) {
                    System.out.println(st);
                    break;
                }
            }
            System.out.println();
        }
        System.out.println(decor("reset"));
    }

    public static void melhoresFilmes() throws Exception {
        try(InputStream input = new FileInputStream("link.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            A1Desafio3.link = prop.getProperty("link.melhoresFilmes");
        }

        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(retornarBody());
        System.out.println("Melhores Filmes:");

        for(Map<String, String> filme : listaDeFilmes) {
            System.out.println(decor("azul") + decor("italic") + filme.get("title") + decor("reset"));
            System.out.println(decor("roxo") +  filme.get("image") + decor("reset"));
            String nota = filme.get("imDbRating");
            StringBuilder st = new StringBuilder();
            int i = 0;
            float casta =  Float.parseFloat(nota); // 9.2
            int castaDnv = (int) casta;

            while (true) {
                st.append(decor("estrela"));
                i++;
                if (i == castaDnv) {
                    System.out.println(st);
                    break;
                }
            }
            System.out.println();
        }
        System.out.println(decor("reset"));
    }

    public static void seriesPopulares() throws Exception {
        try(InputStream input = new FileInputStream("link.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            A1Desafio3.link = prop.getProperty("link.seriesPopulares");
        }
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(retornarBody());
        System.out.println("Séries Populares:");

        for(Map<String, String> filme : listaDeFilmes) {
            System.out.println(decor("verde") + decor("italic") + filme.get("title") + decor("reset"));
            System.out.println(decor("roxo") +  filme.get("image") + decor("reset"));
            String nota = filme.get("imDbRating");
            StringBuilder st = new StringBuilder();
            int i = 0;
            float casta =  Float.parseFloat(nota); // 9.2
            int castaDnv = (int) casta;

            while(true) {
                st.append(decor("estrela"));
                i++;
                if (i == castaDnv) {
                    System.out.println(st);
                    break;
                }
            }
            System.out.println();
        }
        System.out.println(decor("reset"));
    }

    public static void melhoresSeries() throws Exception {
        try(InputStream input = new FileInputStream("link.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            A1Desafio3.link = prop.getProperty("link.melhoresSeries");
        }
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(retornarBody());
        System.out.println("Melhores Séries:");

        for(Map<String, String> filme : listaDeFilmes) {
            System.out.println(decor("roxo") + decor("italic") + filme.get("title") + decor("reset"));
            System.out.println(decor("roxo") +  filme.get("image") + decor("reset"));
            String nota = filme.get("imDbRating");
            StringBuilder st = new StringBuilder();
            int i = 0;
            float casta =  Float.parseFloat(nota); // 9.2
            int castaDnv = (int) casta;
            while(true) {
                st.append(decor("estrela"));
                i++;
                if (i == castaDnv) {
                    System.out.println(st);
                    break;
                }
            }
            System.out.println();
        }
        System.out.println(decor("reset"));
    }

    public static String decor(String decor) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = " \u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_BOLD = "\u001B[1m";
        final String ANSI_ITALIC = "\033[3m";
        final String ANSI_WHITE = "\u001B[37m";
        final String ANSI_STAR = "⭐";

        switch (decor) {
            case "preto" -> {
                return ANSI_BLACK;
            }
            case "vermelho" -> {
                return ANSI_RED;
            }
            case "verde" -> {
                return ANSI_GREEN;
            }
            case "amarelo" -> {
                return ANSI_YELLOW;
            }
            case "azul" -> {
                return ANSI_BLUE;
            }
            case "roxo" -> {
                return ANSI_PURPLE;
            }
            case "ciano" -> {
                return ANSI_CYAN;
            }
            case "branco" -> {
                return ANSI_WHITE;
            }
            case "bold" ->  {
                return ANSI_BOLD;
            }
            case "italic" -> {
                return ANSI_ITALIC;
            }
            case "estrela" -> {
                return ANSI_STAR;
            }
            case "reset" -> {
                return ANSI_RESET;
            }
        }
        return null;
    }
}
