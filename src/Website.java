import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Website {

    int id;
    String name;
    String url;
    int alexa;
    String country;

    public Website() {

    }
}
