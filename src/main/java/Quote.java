import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Quote implements Serializable {

    private String quote;
    private List<String> tags;
    final static long serialVersionUID = 1234567L;


    Quote(String quote) {
        this.quote = quote;
        tags = new ArrayList<String>();
    }

    Quote(String quote, List<String> tags) {
        this.quote = quote;
        this.tags = tags;
    }

    public String getQuote() {
        return quote;
    }
}
