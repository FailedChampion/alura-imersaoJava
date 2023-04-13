import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Propriedade {



    public void criaProp() {


        try(OutputStream output = new FileOutputStream("link.properties")) {
            Properties prop = new Properties();

            prop.setProperty("link.filmesPopulares", "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json");
            prop.setProperty("link.melhoresFilmes", "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json");
            prop.setProperty("link.seriesPopulares", "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json");
            prop.setProperty("link.melhoresSeries", "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json");
            prop.setProperty("link.jaCriado", "1");

            prop.store(output, null);
        }
        catch (IOException io) {
            io.printStackTrace();
        }

    }

}
