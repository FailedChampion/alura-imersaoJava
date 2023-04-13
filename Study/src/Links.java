public enum Links {
    NASA {
        @Override
        public String linkNASA() throws SiteInvalidoException {
            var http = new ClienteHttp();
            String link = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
            return http.buscaDados(link);
        }
    },
    IMDB {
        @Override
        public String linkIMDB() throws SiteInvalidoException {
            var http = new ClienteHttp();
            String link = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
            return http.buscaDados(link);
        }
    },
    PROGRAMACAO {
        @Override
        public String linkCODE() throws SiteInvalidoException {
            var http = new ClienteHttp();
            String link = "http://localhost:8080/linguagens";
            return http.buscaDados(link);
        }
    };

    public String linkNASA() throws SiteInvalidoException {
        var http = new ClienteHttp();
        String link = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        return http.buscaDados(link);
    }

    public String linkIMDB() throws SiteInvalidoException {
        var http = new ClienteHttp();
        String link = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        return http.buscaDados(link);
    }

    public String linkCODE() throws SiteInvalidoException {
        var http = new ClienteHttp();
        String link = "http://localhost:8080/linguagens";
        return http.buscaDados(link);
    }

}
