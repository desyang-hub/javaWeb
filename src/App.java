import java.util.List;

public class App {

    final static int PORT = 8080;
    public static void main(String[] args) {

//        List<Website> list = new DAO().searchAll();
//
//        for(Website site : list) {
//            System.out.printf("Id = %d, Label = %s, Url = %s, Alexa = %d, Country = %s\n", site.getId(), site.getName(), site.getUrl()
//            , site.getAlexa(), site.getCountry());
//        }
        new DAO().add();
    }

}
