import picocli.CommandLine;

import java.util.Arrays;
import java.util.List;

@CommandLine.Command(
        name = "add"
)
public class QuoteeAdd implements Runnable {

    Storage storage;
    @CommandLine.Parameters() String quote;

    @CommandLine.Option(names = "-t", description = "tags") String tags;

    QuoteeAdd(Storage storage) {
        this.storage = storage;
    }

    public void run() {
        System.out.println("Adding quote: " + quote);
        if (tags != null) {
            System.out.println("With tags: " + tags);
            List<String> items = Arrays.asList(tags.split("\\s*,\\s*"));
            storage.addQuote(quote, items);
        } else {
            storage.addQuote(quote);
        }
    }
}